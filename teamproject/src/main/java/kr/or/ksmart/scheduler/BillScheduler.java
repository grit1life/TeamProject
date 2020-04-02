package kr.or.ksmart.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.ksmart.domain.DocBill;
import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.service.DocBillService;
import kr.or.ksmart.service.DocContractFormService;

@Component
public class BillScheduler {
	
	@Autowired
	private DocContractFormService docContractFormService;
	
	@Autowired
	private DocBillService docBillService;
	
	/**
	 * 청구서 자동 발행
	 */
	@Scheduled(cron="0 0 14 10 * *")
	public void insertBill() {
		List<DocContractForm> list = docContractFormService.getContractSchedulerList();
		
		for(int i=0; i<list.size(); i++) {
			int lastCode = docBillService.getBillLastCode();
			lastCode++;
			int billPayNum = docBillService.getBillPayNumber(list.get(i).getContractCode());
			billPayNum++;
			
			DocBill docBill = new DocBill();
			docBill.setBillCode(Integer.toString(lastCode));
			docBill.setContractCode(list.get(i).getContractCode());
			docBill.setBillPayNumber(billPayNum);

			docBillService.insertBill(docBill);
		}
	}		
}
