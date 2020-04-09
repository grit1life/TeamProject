package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.PeriodicInspection;

@Mapper
public interface PeriodicInspectionMapper {
	
	
	//정기점검 코드 자동증가
	public int getPeriodicInspectionCodeMax();
	//정기점검등록
	public int pInsert(PeriodicInspection periodicInspection);
	//정기점검현황리스트
	public List<PeriodicInspection> getPeriodicInspectionList();
	//정기점검 업데이트(값가져오기)
	public PeriodicInspection SelectForUpdate(String checkCode);
	//정기점검 업데이트(값 수정)
	public int pUpdate(PeriodicInspection periodicInspection);
	//정기점검 삭제
	public int pDelete(String checkCode);
	//정기점검 검색 리스트
	public List<PeriodicInspection> periodicInspectionSearchList(String branchName
												   ,String customerName 
												   ,String customerLevel
												   ,String fromDate
												   ,String toDate
												   );
	
	
	
	//개인 고객 팝업창 리스트
	public List<Customer> CustomerList();
	
	
	//개인 고객 팝업창 검색 리스트
	public List<Customer> CustomerSearchList(       String customerId
												   ,String customerName 
												   ,String customerClass
												   ,String customerCall
										     );
	
	//기업고객 팝업창 리스트
	public List<Customer> CustomerCompanyList();
	//기업고객 팝업창 검색 리스트
	public List<Customer> CustomerCompanySearchList(String customerId
												   ,String customerCompanyName 
												   ,String customerClass
												   ,String customerCompanyCall
											     );
	//계약서 팝업창 리스트
	public List<DocContractForm> ContractList();
	//계약서 팝업창 검색 리스트
	public List<DocContractForm> ContractSearchList(String contractCode
												   ,String contractNo	
												   ,String customerId
												   ,String goodsName
							
												  );
	
	
	
	
	

}
