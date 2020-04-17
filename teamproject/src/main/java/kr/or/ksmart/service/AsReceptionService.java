package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.domain.AsRepair;
import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.PeriodicInspection;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.mapper.AsReceptionMapper;


@Service
@Transactional
public class AsReceptionService {
	
	
	@Autowired
	private AsReceptionMapper AsReceptionMapper;
	
	
	//AS 교환 접수 등록
	public int aInsert(AsExchange AsExchange) {
		int max = AsReceptionMapper.getAsReceptionCodeMax()+1;
		String tempCode = "reception_code0";
		
		AsExchange.setReceptionCode(tempCode+max);

		
		return AsReceptionMapper.aInsert(AsExchange);
	}
	
	
	
	
	
	
	//교환 현황 리스트(페이징 포함)
	public Map<String, Object> getAsExchangeList(int currentPage){
		int cnt = AsReceptionMapper.getAsExchangeCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<AsExchange> eList = AsReceptionMapper.getAsExchangeList(firstClmn, lastClmn);
		
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
		map.put("AsExchangeList", eList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}
	
	
	//수리 현황 리스트(페이징 포함)
	public Map<String, Object> getAsRepairList(int currentPage){
		int cnt = AsReceptionMapper.getAsRepairCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<AsRepair> rList = AsReceptionMapper.getAsRepairList(firstClmn, lastClmn);
		
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
		map.put("AsRepairList", rList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}
	
	
	
	
	
	//지점 팝업창 리스트
	public List<Branch> getBranchList() {
		
		return AsReceptionMapper.getBranchList();

	}
	
	//지점 팝업창 검색 리스트
	public List<Branch> getBranchSearchList(String branchName){
		
		return AsReceptionMapper.getBranchSearchList(branchName);
	}
	
	//직원 팝업창 리스트
	public List<Staff> getStaffList() {
			
		return AsReceptionMapper.getStaffList();

	}
	
	//지점 팝업창 검색 리스트
	public List<Staff> getStaffSearchList(String branchName, String staffName){
			
		return AsReceptionMapper.getStaffSearchList(branchName, staffName);
	}
		
	
	
	
	
	
	

}