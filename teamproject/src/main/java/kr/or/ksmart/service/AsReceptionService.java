package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.mapper.AsReceptionMapper;


@Service
@Transactional
public class AsReceptionService {
	
	
	@Autowired
	private AsReceptionMapper AsReceptionMapper;
	
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