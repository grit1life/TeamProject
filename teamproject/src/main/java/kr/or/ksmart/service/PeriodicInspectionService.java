package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.PeriodicInspection;
import kr.or.ksmart.mapper.PeriodicInspectionMapper;

@Service
@Transactional
public class PeriodicInspectionService {
	
	@Autowired
	private PeriodicInspectionMapper periodicInspectionMapper;
	
	// 리스트
		public List<PeriodicInspection> getPeriodicInspectionList() {
			return periodicInspectionMapper.getPeriodicInspectionList();
		
		}
	
}
