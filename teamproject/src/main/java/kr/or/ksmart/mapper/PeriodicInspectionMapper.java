package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.or.ksmart.domain.PeriodicInspection;

@Mapper
public interface PeriodicInspectionMapper {
	
	//리스트
	public List<PeriodicInspection> getPeriodicInspectionList();

}
