package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Deposit;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.mapper.DepositMapper;

@Service
@Transactional
public class DepositService {
	
	@Autowired
	private DepositMapper depositMapper;
	
	@Autowired
	private DocBillService docBillService;
	
	public Pagination<List<Deposit>> getDepositList(int currentPage){
		int cnt = depositMapper.getDepositListCnt();
		int column = (currentPage-1)*10;
		List<Deposit> list = depositMapper.getDepositList(column);
		
		list = calListPayMonth(list);
		
		Pagination<List<Deposit>> pagination = new Pagination<List<Deposit>>
						(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<Deposit>> getPaidDepositList(int currentPage){
		int cnt = depositMapper.getPaidDepositListCnt();
		int column = (currentPage-1)*10;
		List<Deposit> list = depositMapper.getPaidDepositList(column);
		list = calListPayMonth(list);
		Pagination<List<Deposit>> pagination 
					= new Pagination<List<Deposit>>(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<Deposit>> getDepositSearchList(int currentPage, Deposit deposit){
		int cnt = depositMapper.getDepositSearchListCnt(deposit);
		int column = (currentPage-1)*10;
		deposit.setColumn(column);
		List<Deposit> list = depositMapper.getDepositSearchList(deposit);
		list = calListPayMonth(list);
		
		Pagination<List<Deposit>> pagination 
				= new Pagination<List<Deposit>>(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<Deposit>> getPaidDepositSearchList(int currentPage, Deposit deposit){
		int cnt = depositMapper.getPaidDepositSearchListCnt(deposit);
		int column = (currentPage-1)*10;
		deposit.setColumn(column);
		List<Deposit> list = depositMapper.getPaidDepositSearchList(deposit);
		list = calListPayMonth(list);
		
		Pagination<List<Deposit>> pagination 
				= new Pagination<List<Deposit>>(list, currentPage, cnt);

		return pagination;
	}
	
	public int updateDepositList(Map<String, Object> paramMap) {
		int result= depositMapper.updateDepositList(paramMap);
		return result;
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
