package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Grade;
import kr.or.ksmart.domain.Outcome;
import kr.or.ksmart.mapper.StatisticMapper;

@Service
@Transactional
public class StatisticService {
	
	@Autowired
	private StatisticMapper statisMapper;
	
	public List<Grade> getGradeForStatis(){
		List<Grade> gradeList = statisMapper.getGradeForStatis();
		return gradeList;
	}
	
	public List<Outcome> getAllOutCome(){
		List<Outcome> allOutcomeList = statisMapper.getAllOutcome();
		return allOutcomeList;
	}
	
}
