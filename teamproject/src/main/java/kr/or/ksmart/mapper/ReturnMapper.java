package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Return;

@Mapper
public interface ReturnMapper {
	public List<Return> getReturnList(int firstClmn, int lastClmn);
	public int getReturnListCnt();
	
	public List<Return> getReturnCompleteList(int firstClmn, int lastClmn);
	public int getReturnCompleteListCnt();
	
	public List<Return> ajaxReturnList(String contractCode);
}
