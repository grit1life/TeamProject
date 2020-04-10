package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.PeriodicInspection;
import kr.or.ksmart.mapper.PeriodicInspectionMapper;

@Service
@Transactional
public class PeriodicInspectionService {
	
	@Autowired
	private PeriodicInspectionMapper periodicInspectionMapper;
	
	//등록
	public int pInsert(PeriodicInspection periodicInspection) {
		int max = periodicInspectionMapper.getPeriodicInspectionCodeMax()+1;
		String tempCode = "check_";
		
		periodicInspection.setCheckCode(tempCode+max);

		
		return periodicInspectionMapper.pInsert(periodicInspection);
	}
	
	//리스트(페이징 포함)
	public Map<String, Object> getPeriodicInspectionList(int currentPage){
			int cnt = periodicInspectionMapper.getPeriodicInspectionCnt();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<PeriodicInspection> pList = periodicInspectionMapper.getPeriodicInspectionList(firstClmn, lastClmn);
			
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
			map.put("PeriodicInspectionList", pList);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);
			

			
			return map;
		}
	
	//상세보기	
	public PeriodicInspection SelectForUpdate(String checkCode) {
		
		return periodicInspectionMapper.SelectForUpdate(checkCode);
	}
	
	//값 수정
	public int pUpdate(PeriodicInspection periodicInspection) {
		
		return periodicInspectionMapper.pUpdate(periodicInspection);
	}
	
	// 검색 리스트(페이징 포함)	
	public Map<String, Object> PeriodicInspectionSearchList(String branchName
				   ,String customerName
				   ,String customerLevel
				   ,String fromDate
				   ,String toDate	
				   ,int currentPage
				    ){
			
			int cnt = periodicInspectionMapper.findTotalCount();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<PeriodicInspection> pList = periodicInspectionMapper.periodicInspectionSearchList(branchName, customerName, customerLevel, fromDate, toDate, firstClmn, lastClmn);
			
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
			map.put("PeriodicInspectionList", pList);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);

			
			return map;
		}

	
    // 삭제	
	public int pDelte(String checkCode) {
			
		return periodicInspectionMapper.pDelete(checkCode);
	}
	
	
	
	
	// 개인 고객 팝업창 리스트
	public List<Customer> CustomerList() {
			
			
		return periodicInspectionMapper.CustomerList();
			
		}
	
	// 기업고객 팝업창 리스트
	public List<Customer> CustomerCompanyList() {
				
				
			return periodicInspectionMapper.CustomerCompanyList();
				
	}
	
	// 개인 고객 팝업창 검색 리스트
    public List<Customer> CustomerSearchList(       
    		    String customerId
			   ,String customerName 
			   ,String customerClass
			   ,String customerCall
	     ){
    
		return periodicInspectionMapper.CustomerSearchList(customerId, customerName, customerClass, customerCall);
		
    }
    
    // 기업고객 팝업창 검색 리스트
    public List<Customer> CustomerCompanySearchList(       
    		    String customerId
			   ,String customerCompanyName
			   ,String customerClass
			   ,String customerCompanyCall
	     ){
    
		return periodicInspectionMapper.CustomerCompanySearchList(customerId, customerCompanyName, customerClass, customerCompanyCall);
		
    }
    
    //계약서 팝업창 리스트
 	public List<DocContractForm> ContractList() {
 				
 				
 			return periodicInspectionMapper.ContractList();
 				
 	}
 	//계약서 팝업창 리스트
 	public List<DocContractForm> ContractSearchList(
 				String contractCode
			   ,String contractNo
			   ,String customerId
			   ,String goodsName){
 	 				
 	 				
 	 			return periodicInspectionMapper.ContractSearchList(contractCode, contractNo, customerId, goodsName);
 	 				
 	 }
}
