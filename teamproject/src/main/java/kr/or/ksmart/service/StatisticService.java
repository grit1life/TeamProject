package kr.or.ksmart.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Grade;
import kr.or.ksmart.domain.Outcome;
import kr.or.ksmart.domain.ReturnDelay;
import kr.or.ksmart.mapper.StatisticMapper;

@Service
@Transactional
public class StatisticService {
	
	@Autowired
	private StatisticMapper statisMapper;
	
	public List<Grade> getGradeForStatis(){
		return statisMapper.getGradeForStatis();
	}
	public List<Grade> getGradeList(){
		return statisMapper.getGradeList();
	}
	
	public List<Outcome> getAllOutCome(){
		List<Outcome> allOutcomeList = statisMapper.getAllOutcome();
		return allOutcomeList;
	}
	
	public List<Outcome> getPersonalOutcome(){
		List<Outcome> PersnlOutcomeList = statisMapper.getPersonalOutcome();
		return PersnlOutcomeList;
	}
	
	public List<Outcome> getBranchOutcome(){
		List<Outcome> branchOutcomeList = statisMapper.getBranchOutcome();
		return branchOutcomeList;
	}
	
	public List<Outcome> getAllPeriodOutCome(Map<String, Object> map){
		List<Outcome> allPeriodOutcomeList = statisMapper.getAllPeriodOutCome(map);
		return allPeriodOutcomeList;
	}
	
	public List<Outcome> getBranchNameList(){
		List<Outcome> list = statisMapper.getBranchNameList();
		return list;
	}
	public List<Outcome> getBranchPeriodOutcome(Map<String, Object> map){
		List<Outcome> list = statisMapper.getBranchPeriodOutcome(map);
		return list;
	}
	public List<Outcome> getPersnlPeriodOutcome(Map<String, Object> map){
		List<Outcome> list = statisMapper.getPersnlPeriodOutcome(map);
		return list;
	}
	public List<Outcome> getAllPYearOutCome(Map<String, Object> map){
		List<Outcome> list = statisMapper.getAllPYearOutCome(map);
		return list;
	}
	public List<Outcome> getBranchPYearOutcome(Map<String, Object> map){
		List<Outcome> list = statisMapper.getBranchPYearOutcome(map);
		return list;
	}
	public List<Outcome> getPersnlPYearOutcome(Map<String, Object> map){
		List<Outcome> list = statisMapper.getPersnlPYearOutcome(map);
		return list;
	}
	
	public List<Outcome> getBranchStaff(){
		List<Outcome> list = statisMapper.getBranchStaff();
		return list;
	}
	
	public List<ReturnDelay> getReturnDelayList(){
		return statisMapper.getReturnDelayList();
	}
	public List<Map<String, Object>> getDelayChart(){
		return statisMapper.getDelayChart();
	}
}
