package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.DocEstimateForm;





@Mapper
public interface CustomerMapper {
	
	//개인고객 등록
	public int cInsert(Customer customer); 	
	//개인고객 리스트 페이징 카운트
	public int getCustomerCnt();	
	//개인고객 리스트 페이징 
	public List<Customer> getCustomerList(int startClmn, int endClmn);
	//개인고객 업데이트(값가져오기)
	public Customer SelectForUpdate(String customerId); 
	//개인고객 업데이트(값 수정)
	public int cUpdate(Customer customer);
	//개인고객 삭제
	public int cDelete(String customerId, String customerName);
	//개인고객 검색 리스트 페이징 카운트
	public int findTotalCount();
	//개인고객 검색 리스트
	public List<Customer> getCustomerSearchList(String customerId
											   ,String customerName 
											   ,String customerClass
											   ,String fromDate
											   ,String toDate
											   ,int startClmn
											   ,int endClmn
											   );
	
	//개인사업&법인 고객 등록
	public int cInsert2(Customer customer); 
	//개인사업&법인 리스트 페이징 카운트
	public int getCustomerCompanyCnt();
	//개인사업&법인 고객 리스트        
	public List<Customer> getCustomerCompanyList(int startClmn, int endClmn);		
	//개인사업&법인 업데이트(값가져오기)
	public Customer SelectForUpdate2(String customerId); 
	//개인사업&법인 업데이트(값 수정)
	public int cUpdate2(Customer customer);
	//개인사업&법인 삭제
	public int cDelete2(String customerId, String customerName);
	//개인사업&법인 검색 리스트 페이징 카운트
	public int findTotalCount2();
	//개인사업&법인 검색 리스트
	public List<Customer> getCustomerSearchList2(String customerId
												  ,String customerCompanyName 
												  ,String customerClass
												  ,String customerLevel
												  ,String fromDate
												  ,String toDate
												  ,int startClmn
												  ,int endClmn
												   );
	
	
}
