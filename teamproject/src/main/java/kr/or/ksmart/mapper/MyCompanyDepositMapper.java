package kr.or.ksmart.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.MyCompanyDeposit;

@Mapper
public interface MyCompanyDepositMapper {
	
	public MyCompanyDeposit getMyCompanyDeposit();
}
