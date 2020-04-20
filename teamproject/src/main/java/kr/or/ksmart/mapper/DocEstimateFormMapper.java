package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.domain.PriceSet;
import kr.or.ksmart.domain.Staff;


@Mapper
public interface DocEstimateFormMapper {

	public List<DocEstimateForm> getEstimateList(int column);
	public int getEstimateListCnt();
	public List<Staff> getStaffNameList();
	public List<PriceSet> getSetNameList();
	public List<Goods> getGoodsNameList();
	public List<DocEstimateForm> getEstimateSearchList(DocEstimateForm docEstimateForm);
	public int getEstimateSearchListCnt();
	
	public List<DocEstimateForm> getCusEstimateList(String cId);
	
	/*public List<DocEstimateForm> getAjaxFormList(String estimateCode);*/
	
	public List<DocEstimateForm> getEstimateForm(String estimateCode);
	public int getEstimateFormCnt(String estimateCode);
	
	public Mycompany getMycompany();
}
