package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.mapper.CustomerMapper;


@Service
@Transactional
public class CustomerService {
	
	
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<Customer> getCustomerList() {
		return customerMapper.getCustomerList();

	
	}
	
	
	
	

}
