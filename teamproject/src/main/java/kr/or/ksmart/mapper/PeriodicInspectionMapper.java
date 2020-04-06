package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.PeriodicInspection;

@Mapper
public interface PeriodicInspectionMapper {
	
	//정기점검현황리스트
	public List<PeriodicInspection> getPeriodicInspectionList();
	//정기점검 코드 자동증가
	public int getPeriodicInspectionCodeMax();
	//정기점검등록
	public int pInsert(PeriodicInspection periodicInspection);
	
	//개인 고객 모달창 리스트
	public List<Customer> CustomerList();
	
	
	//개인 고객 모달창 검색 리스트
	public List<Customer> CustomerSearchList(       String customerId
												   ,String customerName 
												   ,String customerClass
												   ,String customerCall
										     );

}
