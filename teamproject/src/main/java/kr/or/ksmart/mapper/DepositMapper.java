package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Deposit;

@Mapper
public interface DepositMapper {

	public List<Deposit> getDepositList(int firstClmn, int lastClmn);
	public int getDepositListCnt();
	
	public List<Deposit> getPaidDepositList(int firstClmn, int lastClmn);
	public int getPaidDepositListCnt();
}
