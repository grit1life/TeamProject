package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocEstimateForm;


@Mapper
public interface DocEstimateFormMapper {

	public List<DocEstimateForm> getEstimateList();

	public List<DocEstimateForm> getEstimateList(String cId);
	
}
