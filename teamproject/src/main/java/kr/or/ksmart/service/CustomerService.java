package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.DocEstimateForm;
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
	
	
	//개인 고객 업데이트(값가져오기)
		
	public Customer SelectForUpdate(String customerId) {
		
		return customerMapper.SelectForUpdate(customerId);
	}
	
	//개인 고객 업데이트(값 수정)
	public int cUpdate(Customer customer) {
		return customerMapper.cUpdate(customer);
		
	}
	
	//개인 고객 삭제
	
	public int cDelte(String customerId, String customerName) {
		return customerMapper.cDelete(customerId, customerName);
	}
	
	//개인고객검색
	
	public List<Customer> getCustomerSearchList(String customerId
			   ,String customerName
			   ,String customerClass
			   ,String fromDate
			   ,String toDate
			    ){
		
		return customerMapper.getCustomerSearchList(customerId, customerName, customerClass, fromDate, toDate);
	}

	
	
	//개인 사업& 법인 고객 등록1 
	
	public int cInsert2(Customer customer){
			
		return customerMapper.cInsert2(customer);
			
		}
		
	
	
	
	//개인 사업& 법인 고객 리스트
	public List<Customer> getCustomerCompanyList() {
			return customerMapper.getCustomerCompanyList();

		
		}
		
   //개인 사업& 법인 고객 업데이트(값가져오기)
	public Customer SelectForUpdate2(String customerId) {
			
			return customerMapper.SelectForUpdate2(customerId);
		} 
		
	//개인 사업& 법인 고객 업데이트(값 수정)
	public int cUpdate2(Customer customer) {
			return customerMapper.cUpdate2(customer);
			
		}		
   //개인 사업& 법인 고객 삭제
		
	public int cDelte2(String customerId, String customerName) {
			return customerMapper.cDelete2(customerId, customerName);
		}
  //개인고객검색
	
	public List<Customer> getCustomerSearchList2(String customerId
											    ,String customerName
											    ,String customerClass
											    ,String customerLevel
											    ,String fromDate
											    ,String toDate
											    ){
			
			return customerMapper.getCustomerSearchList2(customerId, customerName, customerClass, customerLevel, fromDate, toDate);
		}
	
	
	
	

}
