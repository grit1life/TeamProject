package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.mapper.BranchMapper;

@Service
@Transactional
public class BranchService {
	
	
	
	@Autowired
	private BranchMapper branchMapper;
	
	
	public int bInsert(Branch branch){
			
		return branchMapper.bInsert(branch);
			
	}
	
	public List<Branch> getBranchList() {
		return branchMapper.getBranchList();

	
	}
	

	
	public Branch SelectForUpdate(String branchCode) {
			
			return branchMapper.SelectForUpdate(branchCode);
		}
		
	
		public int bUpdate(Branch branch) {
			return branchMapper.bUpdate(branch);
			
		}		
		
		public int bDelte(String branchCode, String branchName) {
			return branchMapper.bDelete(branchCode, branchName);
		}
		
	public List<Branch> selectBranch(){
			return branchMapper.selectBranch();			
	}
	
	
	
	

}
