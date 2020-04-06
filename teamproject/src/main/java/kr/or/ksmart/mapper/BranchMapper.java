package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Customer;


@Mapper
public interface BranchMapper {
	
	public int bInsert(Branch branch); 
	
	public List<Branch> getBranchList();
	

	public List<Branch> getBranchSearchList(        String branchCode
												   ,String staffName 
												   ,String branchName
												   ,String branchPhone
												   ,String fromDate
												   ,String toDate
												   );
	
	public Branch SelectForUpdate(String branchCode); 
	
	public int bUpdate(Branch branch);

	public int bDelete(String branchCode, String branchName);	
	
	public List<Branch> selectBranch();

}
