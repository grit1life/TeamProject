package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Commute;

@Mapper
public interface CommuteMapper {
	
	public List<Commute> commuteList(String staffId);

}
