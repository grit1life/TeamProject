package kr.or.ksmart.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	
	public List<DocBill> getDocBillList(){
		List<DocBill> list = docBillMapper.getDocBillList();
		
		for(int i=0; i<list.size(); i++) {
			String fromDate = list.get(i).getRentalFromDate();
			String toDate = list.get(i).getRentalToDate();
			double total = list.get(i).getTotal();
			
			total = calPayMonth(fromDate, toDate, total);
			
			list.get(i).setPayMonth((int)total);
		}
		
		return list;
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
