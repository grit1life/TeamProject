package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.domain.Holiday;

@Mapper
public interface CommuteMapper {
	
	public List<Commute> commuteList(Map<String, Object> paramMap);
	
	public int getCommuteListCnt(String staffId);

	public List<Holiday> getHolidayList(String staffId);
	public List<Holiday> getHolidayListNow(String staffId);
	
	public Integer getHolidayCode();
	
	public int insertHoliday(Holiday holiday);
	
	public int deleteHoliday(String hCode);
}
