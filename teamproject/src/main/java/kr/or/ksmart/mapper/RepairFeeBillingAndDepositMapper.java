package kr.or.ksmart.mapper;

import kr.or.ksmart.domain.RepairFeeBillingAndDeposit;

public interface RepairFeeBillingAndDepositMapper {
	
	
	
		//코드 자동증가
		public int getrepairFeeBillingAndDepositCodeMax();
		//등록
		public int rdInsert(RepairFeeBillingAndDeposit RepairFeeBillingAndDeposit);

}
