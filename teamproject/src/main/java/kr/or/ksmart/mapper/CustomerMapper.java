package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.domain.Customer;



@Mapper
public interface CustomerMapper {
	
	public int cInsert(Customer customer); 
	
	public List<Customer> getCustomerList();

}
