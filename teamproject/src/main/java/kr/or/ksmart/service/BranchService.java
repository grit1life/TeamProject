package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getBranchList(int currentPage){
		int cnt = branchMapper.getBranchCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Branch> bList = branchMapper.getBranchList(firstClmn, lastClmn);
		
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
		map.put("BranchList", bList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
		
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
	
	public Map<String, Object> getBranchSearchList(String branchCode
				   ,String staffName
				   ,String branchName
				   ,String branchPhone
				   ,String fromDate
				   ,String toDate	
				   ,int currentPage
				    ){
			
			int cnt = branchMapper.findTotalCount();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<Branch> bList = branchMapper.getBranchSearchList(branchCode, staffName, branchName, branchPhone, fromDate, toDate, firstClmn, lastClmn);
			
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
			map.put("BranchList", bList);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);

			
			return map;
		}
	



}
	
	
	
	


