package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Commute;

@Mapper
public interface CommuteMapper {
	
	public List<Commute> commuteList(Map<String, Object> paramMap);
	
	public int getCommuteListCnt(String staffId);

}
