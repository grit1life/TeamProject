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
import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.mapper.DocBillMapper;

@Service
@Transactional
public class DocBillService {

	@Autowired
	private DocBillMapper docBillMapper;
	
	public int insertBill(DocBill docBill) {
		return docBillMapper.insertBill(docBill);
	}
	public int getBillPayNumber(String contractCode) {
		return docBillMapper.getBillPayNumber(contractCode);
	}
	
	public int getBillLastCode() {
		return docBillMapper.getBillLastCode();
	}
	
	public Pagination<List<DocBill>> getDocBillList(int currentPage){
		
		int cnt = docBillMapper.getDocBillListCnt();
		int column = (currentPage-1)*10;
		List<DocBill> list = docBillMapper.getDocBillList(column);
		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = calPayMonth(fromDate, toDate, total);
			
			list.get(i).setPayMonth((int)total);
		}
		
		Pagination<List<DocBill>> pagination = new Pagination<List<DocBill>>
								(list, currentPage, cnt);
				
		return pagination;
		
	}
	public Pagination<List<DocBill>> getDocBillSearchList(int currentPage, DocBill docBill){
		
		int cnt = docBillMapper.getDocBillSearchListCnt(docBill);
		int column = (currentPage-1)*10;
		docBill.setColumn(column);
		List<DocBill> list = docBillMapper.getDocBillSearchList(docBill); 
		
		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = calPayMonth(fromDate, toDate, total);
			
			list.get(i).setPayMonth((int)total);
		}
		
		Pagination<List<DocBill>> pagination = new Pagination<List<DocBill>>
		(list, currentPage, cnt);
		
		return pagination;
		
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date FirstDate = format.parse(fromDate);
			Date SecondDate = format.parse(toDate);
			long calDate = SecondDate.getTime() - FirstDate.getTime(); 
	
			long calDateDays = calDate / (24*60*60*1000); 
			System.out.println(calDateDays);
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
