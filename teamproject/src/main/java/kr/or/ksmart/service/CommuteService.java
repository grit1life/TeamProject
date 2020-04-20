package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.domain.Holiday;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.mapper.CommuteMapper;

@Service
@Transactional
public class CommuteService {
	
	@Autowired
	private CommuteMapper commuteMapper;
	
	public Pagination<List<Commute>> CommuteList(String staffId, int currentPage){
		int column = (currentPage-1) * 10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staffId", staffId);
		map.put("column", column);
		List<Commute> list = commuteMapper.commuteList(map);
		int cnt = commuteMapper.getCommuteListCnt(staffId);
		
		Pagination<List<Commute>> p = new Pagination<List<Commute>>(currentPage, cnt);
		p.setList(list);
		
		return p;
	}
	
	public List<Holiday> getHolidayList(String staffId){
		List<Holiday> hList = commuteMapper.getHolidayList(staffId);
		return hList;
	}
	public List<Holiday> getHolidayListNow(String staffId){
		List<Holiday> hNowList = commuteMapper.getHolidayListNow(staffId);
		return hNowList;
	}
	
	public void insertHoliday(Holiday holiday) {
		Integer no = commuteMapper.getHolidayCode();
		if(no == null) {
			no = 0;
		}
		holiday.setHolidayCode(Integer.toString(no+1));
		commuteMapper.insertHoliday(holiday);
	}
	
	public void deleteHoliday(String hCode) {
		commuteMapper.deleteHoliday(hCode);
	}
}
