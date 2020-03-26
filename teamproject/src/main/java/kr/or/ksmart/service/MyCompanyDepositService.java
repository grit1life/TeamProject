package kr.or.ksmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.MyCompanyDeposit;
import kr.or.ksmart.mapper.MyCompanyDepositMapper;

@Service
@Transactional
public class MyCompanyDepositService {
	
	@Autowired
	private MyCompanyDepositMapper myCompanyDepositMapper;
	
	public MyCompanyDeposit getMyCompanyDeposit() {
		MyCompanyDeposit deposit = myCompanyDepositMapper.getMyCompanyDeposit();
		return deposit;
	}
}
