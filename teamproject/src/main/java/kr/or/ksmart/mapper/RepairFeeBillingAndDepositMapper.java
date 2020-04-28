package kr.or.ksmart.mapper;

import java.util.List;

import kr.or.ksmart.domain.RepairFeeBillingAndDeposit;

public interface RepairFeeBillingAndDepositMapper {
	
	
	
		//코드 자동증가
		public int getrepairFeeBillingAndDepositCodeMax();
		//등록
		public int rdInsert(RepairFeeBillingAndDeposit RepairFeeBillingAndDeposit);
		//리스트 페이징 카운트
		public int getrepairFeeBillingAndDepositCnt();		
		//리스트
		public List<RepairFeeBillingAndDeposit> getrepairFeeBillingAndDepositList(int startClmn, int endClmn);
		

}
