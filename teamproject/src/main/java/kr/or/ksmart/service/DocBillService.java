package kr.or.ksmart.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocBill;
import kr.or.ksmart.mapper.DocBillMapper;

@Service
@Transactional
public class DocBillService {

	@Autowired
	private DocBillMapper docBillMapper;
	
	public int insertBill(DocBill docBill) {
		int result = docBillMapper.insertBill(docBill);
		return result;
	}
	public int getBillPayNumber(String contractCode) {
		int billPayNumber = docBillMapper.getBillPayNumber(contractCode);
		return billPayNumber;
	}
	
	public int getBillLastCode() {
		int lastCode = docBillMapper.getBillLastCode();
		return lastCode;
	}
	
	public Map<String, Object> getDocBillList(int currentPage){
		
		int cnt = docBillMapper.getDocBillListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<DocBill> list = docBillMapper.getDocBillList(firstClmn, lastClmn);
		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = calPayMonth(fromDate, toDate, total);
			
			list.get(i).setPayMonth((int)total);
		}
		
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
		
	}
	public Map<String, Object> getDocBillSearchList(int currentPage, DocBill docBill){
		
		int cnt = docBillMapper.getDocBillSearchListCnt(docBill);
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		docBill.setFirstClmn(firstClmn);
		docBill.setLastClmn(lastClmn);
		List<DocBill> list = docBillMapper.getDocBillSearchList(docBill); 
		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = calPayMonth(fromDate, toDate, total);
			
			list.get(i).setPayMonth((int)total);
		}
		
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
		
	}
	
	public DocBill getDocBillForm(String billCode) {
		DocBill docBill = docBillMapper.getDocBillForm(billCode);
		String fromDate = docBill.getRentalFromDate();
		String toDate = docBill.getRentalToDate();
		double total = docBill.getTotal();
		
		total = calPayMonth(fromDate, toDate, total);
		
		docBill.setPayMonth((int)total);
		
		return docBill;
	}
	
	/**
	 * 	월 청구 금액 계산
	 * @param fromDate
	 * @param toDate
	 * @param total
	 * @return
	 */
	public double calPayMonth(String fromDate, String toDate, double total) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date FirstDate = format.parse(fromDate);
			Date SecondDate = format.parse(toDate);
			long calDate = FirstDate.getTime() - SecondDate.getTime(); 
			long calDateDays = calDate / (24*60*60*1000); 
			calDateDays = Math.abs(calDateDays);
			int month = (int)calDateDays/30;
			
			total = total/month;
			total = Math.ceil(total / 100);
			total = total*100;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return total;
	}
}
