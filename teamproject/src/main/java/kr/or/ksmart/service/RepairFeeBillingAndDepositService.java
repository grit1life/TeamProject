package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		//리스트(페이징 포함)
		public Map<String, Object> getrepairFeeBillingAndDepositList(int currentPage){
			int cnt = RepairFeeBillingAndDepositMapper.getrepairFeeBillingAndDepositCnt();
			int firstClmn = (currentPage-1)*10;
			int lastClmn = firstClmn +10;
			List<RepairFeeBillingAndDeposit> rbList = RepairFeeBillingAndDepositMapper.getrepairFeeBillingAndDepositList(firstClmn, lastClmn);
			
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
			map.put("RepairFeeBillingAndDepositList", rbList);
			map.put("currentPage", currentPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("lastPage", lastPage);
			
			return map;
		}
		
		// 삭제	
		public int rdDelete(String claimCode) {
								
			return RepairFeeBillingAndDepositMapper.rdDelete(claimCode);
		}
	
	
	

}
