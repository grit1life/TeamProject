package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Grade;
import kr.or.ksmart.domain.Outcome;
import kr.or.ksmart.domain.ReturnDelay;

@Mapper
public interface StatisticMapper {
	
	public List<Grade> getGradeForStatis();
	public List<Grade> getGradeList();
	
	public List<Outcome> getAllOutcome();
	
	public List<Outcome> getPersonalOutcome();
	
	public List<Outcome> getBranchOutcome();
	
	public List<Outcome> getAllPeriodOutCome(Map<String, Object> map);
	public List<Outcome> getBranchNameList();
	public List<Outcome> getBranchPeriodOutcome(Map<String, Object> map);
	public List<Outcome> getPersnlPeriodOutcome(Map<String, Object> map);
	
	public List<Outcome> getAllPYearOutCome(Map<String, Object> map);
	public List<Outcome> getBranchPYearOutcome(Map<String, Object> map);
	public List<Outcome> getPersnlPYearOutcome(Map<String, Object> map);
	
	public List<Outcome> getBranchStaff();
	public List<ReturnDelay> getReturnDelayList();
	public List<Map<String, Object>> getDelayChart();
}
