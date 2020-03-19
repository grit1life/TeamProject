package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Grade;
import kr.or.ksmart.domain.Outcome;

@Mapper
public interface StatisticMapper {
	
	public List<Grade> getGradeForStatis();
	
	public List<Outcome> getAllOutcome();
	
	public List<Outcome> getPersonalOutcome();
	
	public List<Outcome> getBranchOutcome();
	
}
