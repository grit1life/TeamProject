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
	//개인고객 리스트
	public List<Customer> getCustomerList();
	//개인고객 업데이트(값가져오기)
	public Customer SelectForUpdate(String customerId); 
	//개인고객 업데이트(값 수정)
	public int cUpdate(Customer customer);
	//개인고객 삭제
	public int cDelete(String customerId);	
	//개인사업&법인 고객 리스트        
	public List<CustomerCompany> getCustomerCompanyList();
	
	
}
