package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Mycompany;


@Mapper
public interface DocEstimateFormMapper {

	public List<DocEstimateForm> getEstimateList();

	public List<DocEstimateForm> getEstimateList(String cId);
	
	public List<DocEstimateForm> getAjaxFormList(String estimateCode);
	
	public List<DocEstimateForm> getEstimateForm(String estimateCode, String no);
	
	public Mycompany getMycompany();
}
