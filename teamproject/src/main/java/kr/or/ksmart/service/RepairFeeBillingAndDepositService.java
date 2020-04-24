package kr.or.ksmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.RepairFeeBillingAndDeposit;
import kr.or.ksmart.mapper.RepairFeeBillingAndDepositMapper;

@Service
@Transactional
public class RepairFeeBillingAndDepositService {
	
	@Autowired
	private RepairFeeBillingAndDepositMapper RepairFeeBillingAndDepositMapper;
	
	
	
	
		// 등록
		public int rdInsert(RepairFeeBillingAndDeposit RepairFeeBillingAndDeposit) {
			int max = RepairFeeBillingAndDepositMapper.getrepairFeeBillingAndDepositCodeMax()+1;
			String tempCode = "claim_code0";
			
			RepairFeeBillingAndDeposit.setClaimCode(tempCode+max);

			
			return RepairFeeBillingAndDepositMapper.rdInsert(RepairFeeBillingAndDeposit);
		}
		
	
	
	

}
