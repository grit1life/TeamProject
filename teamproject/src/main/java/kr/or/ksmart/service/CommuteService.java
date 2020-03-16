package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.mapper.CommuteMapper;

@Service
@Transactional
public class CommuteService {
	
	@Autowired
	private CommuteMapper commuteMapper;
	
	public List<Commute> CommuteList(String staffId){
		List<Commute> cList = commuteMapper.commuteList(staffId);
		return cList;
	}
}
