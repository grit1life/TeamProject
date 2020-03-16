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
	
	public List<Branch> getBranchList() {
		return branchMapper.getBranchList();

	
	}
	
	
	
	

}
