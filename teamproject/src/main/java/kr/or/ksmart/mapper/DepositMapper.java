package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Deposit;

@Mapper
public interface DepositMapper {

	public List<Deposit> getDepositList(int firstClmn, int lastClmn);
	public int getDepositListCnt();
	
	public List<Deposit> getPaidDepositList(int firstClmn, int lastClmn);
	public int getPaidDepositListCnt();
	
	
	public List<Deposit> getDepositSearchList(Deposit deposit);
	public int getDepositSearchListCnt(Deposit deposit);
	public List<Deposit> getPaidDepositSearchList(Deposit deposit);
	public int getPaidDepositSearchListCnt(Deposit deposit);
	
	public int updateDepositList(Map<String, Object> paramMap);
}
