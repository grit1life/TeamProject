package kr.or.ksmart.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.PeriodicInspection;
import kr.or.ksmart.mapper.PeriodicInspectionMapper;

@Service
@Transactional
public class PeriodicInspectionService {
	
	@Autowired
	private PeriodicInspectionMapper periodicInspectionMapper;
	
	// 리스트
	public List<PeriodicInspection> getPeriodicInspectionList() {
		
		
		return periodicInspectionMapper.getPeriodicInspectionList();
		
		}
	
	// 개인 고객 모달창 리스트
	public List<Customer> CustomerList() {
			
			
		return periodicInspectionMapper.CustomerList();
			
		}
	
	// 개인 고객 모달창 검색 리스트
    public List<Customer> CustomerSearchList(       
    		    String customerId
			   ,String customerName 
			   ,String customerClass
			   ,String customerCall
	     ){
    
		return periodicInspectionMapper.CustomerSearchList(customerId, customerName, customerClass, customerCall);
		
    }
	
	//등록
	public int pInsert(PeriodicInspection periodicInspection) {
		int max = periodicInspectionMapper.getPeriodicInspectionCodeMax()+1;
		String tempCode = "check_";
		
		periodicInspection.setCheckCode(tempCode+max);

		
		return periodicInspectionMapper.pInsert(periodicInspection);
	}

	
}
