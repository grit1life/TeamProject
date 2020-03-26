package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Deposit;
import kr.or.ksmart.mapper.DepositMapper;

@Service
@Transactional
public class DepositService {
	
	@Autowired
	private DepositMapper depositMapper;
	
	@Autowired
	private DocBillService docBillService;
	
	public List<Deposit> getDepositList(){
		List<Deposit> list = depositMapper.getDepositList();
		list = calListPayMonth(list);
		return list;
	}
	public List<Deposit> getDepositList(boolean paid){
		List<Deposit> list = depositMapper.getDepositList(paid);
		list = calListPayMonth(list);
		return list;
	}
	
	/**
	 * 	월납부 금액 계산
	 * @param list
	 * @return
	 */
	public List<Deposit> calListPayMonth(List<Deposit> list){

		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = docBillService.calPayMonth(fromDate, toDate, total);
			list.get(i).setPayMonth((int)total);
		}
		return list;
	}
}
