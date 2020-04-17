package kr.or.ksmart.mapper;

import java.util.List;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.domain.AsRepair;
import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Staff;


public interface AsReceptionMapper {
	
	
	//AS접수 코드 자동증가
	public int getAsReceptionCodeMax();
	//AS접수 교환 등록
	public int aInsert(AsExchange AsExchange);
	
	//교환 현황 리스트 페이징 카운트
	public int getAsExchangeCnt();
	
	//교환 현황 리스트
	public List<AsExchange> getAsExchangeList(int startClmn, int endClmn);
	
	
	//수리 현황 리스트 페이징 카운트
	public int getAsRepairCnt();
	
	//수리 현황 리스트
	public List<AsRepair> getAsRepairList(int startClmn, int endClmn);
	
	
	
	

	//지점 팝업창 리스트
	public List<Branch> getBranchList();
	
	//지점 팝업창 검색 리스트
	public List<Branch> getBranchSearchList(String branchName);
	
	//직원 팝업창 리스트
	public List<Staff> getStaffList();
	
	//직원 팝업창 검색 리스트
	public List<Staff> getStaffSearchList(String branchName, String staffName);
	

	



}
	

