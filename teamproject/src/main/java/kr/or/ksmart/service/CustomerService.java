package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Board;
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
	
	//리스트(페이징 포함)
	public Map<String, Object> getCustomerList(int currentPage){
		int cnt = customerMapper.getCustomerCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Customer> cList = customerMapper.getCustomerList(firstClmn, lastClmn);
		
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
		map.put("CustomerList", cList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
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
	
	//개인고객 검색 리스트(페이징 포함)	
	public Map<String, Object> getCustomerSearchList(String customerId
			   ,String customerName
			   ,String customerClass
			   ,String fromDate
			   ,String toDate	
			   ,int currentPage
			    ){
		
		int cnt = customerMapper.findTotalCount();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Customer> cList = customerMapper.getCustomerSearchList(customerId, customerName, customerClass, fromDate, toDate, firstClmn, lastClmn);
		
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
		map.put("CustomerList", cList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);

		
		return map;
	}

	
	
	//개인 사업& 법인 고객 등록1 
	
	public int cInsert2(Customer customer){
			
		return customerMapper.cInsert2(customer);
			
		}
		
	
	//개인 사업& 법인 고객 리스트
	public Map<String, Object> getCustomerCompanyList(int currentPage){
			int cnt = customerMapper.getCustomerCompanyCnt();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<Customer> cList2 = customerMapper.getCustomerCompanyList(firstClmn, lastClmn);
			
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
			map.put("CustomerCompanyList", cList2);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);
			
			return map;
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
	
	//개인 사업& 법인 검색 리스트(페이징 포함)	
	public Map<String, Object> getCustomerSearchList2(String customerId
				   ,String customerCompanyName
				   ,String customerClass
				   ,String customerLevel
				   ,String fromDate
				   ,String toDate	
				   ,int currentPage
				    ){
			
			int cnt = customerMapper.findTotalCount2();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<Customer> cList2 = customerMapper.getCustomerSearchList2(customerId, customerCompanyName, customerClass, customerLevel, fromDate, toDate, firstClmn, lastClmn);
			
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
			map.put("CustomerCompanyList", cList2);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);

			
			return map;
		}
	

	
	
	

}
