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
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	        Date FirstDate;
			try {
				FirstDate = format.parse(fromDate);
				Date SecondDate = format.parse(toDate);
				long calDate = FirstDate.getTime() - SecondDate.getTime(); 
				long calDateDays = calDate / (24*60*60*1000); 
				calDateDays = Math.abs(calDateDays);
				int month = (int)calDateDays/30;
				
				double total = list.get(i).getTotal();
				total = total/month;
				total = Math.ceil(total / 100);
				total = total*100;
				list.get(i).setPayMonth((int)total);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public DocBill getDocBillForm(String billCode) {
	}
}
