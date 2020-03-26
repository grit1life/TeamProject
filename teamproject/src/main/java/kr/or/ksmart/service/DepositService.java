package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getDepositList(int currentPage){
		int cnt = depositMapper.getDepositListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Deposit> list = depositMapper.getDepositList(firstClmn, lastClmn);
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		list = calListPayMonth(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
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
