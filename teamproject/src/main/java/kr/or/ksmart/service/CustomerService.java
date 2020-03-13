package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.CustomerCompany;
import kr.or.ksmart.mapper.CustomerMapper;



@Service
@Transactional
public class CustomerService {
	
	
	
	@Autowired
	private CustomerMapper customerMapper;
	
	
	//개인 고객 등록 
	
	public int cInsert(Customer customer){
		
		return customerMapper.cInsert(customer);
		
	}
	//개인 고객 리스트
	public List<Customer> getCustomerList() {
		return customerMapper.getCustomerList();

	
	}
	
	//개인 사업& 법인 거래처 고객 고객 리스트
		public List<CustomerCompany> getCustomerCompanyList() {
			return customerMapper.getCustomerCompanyList();

		
		}
	
	
	
	

}
