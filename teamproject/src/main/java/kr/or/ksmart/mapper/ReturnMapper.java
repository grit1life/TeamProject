package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Return;
import kr.or.ksmart.domain.ReturnSearchForm;

@Mapper
public interface ReturnMapper {
	public List<Return> getReturnList(int firstClmn, int lastClmn);
	public int getReturnListCnt();
	
	public List<Return> getReturnSearchList(ReturnSearchForm rsf);
	public int getReturnSearchListCnt(ReturnSearchForm rsf);
	
	public List<Return> getReturnCompleteList(int firstClmn, int lastClmn);
	public int getReturnCompleteListCnt();
	
	public List<Return> getReturnCompleteSearchList(ReturnSearchForm rsf);
	public int getReturnCompleteSearchListCnt(ReturnSearchForm rsf);
	
	public List<Return> ajaxReturnList(String contractCode);
	
	public String getReturnedCode(String rContractCode);
	public int updateReturnedDate(String rContractCode);
	public int updateReturned(String rContractCode);
	public int insertReturnedDate(String rContractCode);
	public int insertLate();
}
