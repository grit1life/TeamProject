package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.CustomerCompany;



@Mapper
public interface CustomerMapper {
	
	//개인고객 등록
	public int cInsert(Customer customer); 
	//개인사업&법인 고객 등록
	public int cInsert2(Customer customer); 
	//개입고객 리스트
	public List<Customer> getCustomerList();
	//개인사업&법인 고객 리스트        
	public List<CustomerCompany> getCustomerCompanyList();
	
	
}
