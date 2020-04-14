package kr.or.ksmart.mapper;

import java.util.List;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Staff;


public interface AsReceptionMapper {

	//지점 팝업창 리스트
	public List<Branch> getBranchList();
	
	//지점 팝업창 검색 리스트
	public List<Branch> getBranchSearchList(String branchName);
	
	//직원 팝업창 리스트
	public List<Staff> getStaffList();
	
	//직원 팝업창 검색 리스트
	public List<Staff> getStaffSearchList(String branchName, String staffName);
	

	



}
	

