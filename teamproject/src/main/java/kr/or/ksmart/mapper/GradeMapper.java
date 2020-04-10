package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Customer;

@Mapper
public interface GradeMapper {
		
	public List<Customer> getCustomerList(); 
	
	public String divideGrade(String customerId);
	public int updateGrade(String customerId, String grade);
	public int insertGradeRecord();
}
