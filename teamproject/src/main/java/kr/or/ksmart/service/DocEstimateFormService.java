package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.mapper.DocEstimateFormMapper;

@Service
@Transactional
public class DocEstimateFormService {
	
	@Autowired
	private DocEstimateFormMapper docEstimateFormMapper;
	
	public List<DocEstimateForm> getEstimateList(){
		List<DocEstimateForm> eList  = docEstimateFormMapper.getEstimateList();
		return eList;
	}

	public List<DocEstimateForm> getEstimateList(String cId){
		List<DocEstimateForm> eList  = docEstimateFormMapper.getEstimateList(cId);
		return eList;
	}
	/*
	public List<DocEstimateForm> getAjaxFormList(Map<String, Object> map){
		String estimateCode = (String) map.get("estimateCode");
		List<DocEstimateForm> list = docEstimateFormMapper.getAjaxFormList(estimateCode);
		return list;
	}*/
	
	public List<DocEstimateForm> getEstimateForm(String estimateCode) {
		List<DocEstimateForm> eList = docEstimateFormMapper.getEstimateForm(estimateCode);

		List<DocEstimateForm> resultList = new ArrayList<DocEstimateForm>();
		for(int i=0; i<eList.size(); i++) {
			if(i==0) {
				resultList.add(eList.get(i));
			}else if(!eList.get(i).getEstimateNo().equals( eList.get(i-1).getEstimateNo() )) {
				if(eList.get(i).getSetCode()!=null) {
					resultList.add(eList.get(i));
				}else {
					resultList.add(eList.get(i));
				}
			}
			if(eList.get(i).getSetCode()!=null) {
				DocEstimateForm form = new DocEstimateForm();
				form.setSetCode(eList.get(i).getSetCode());
				form.setSetName(eList.get(i).getSetGoodsName());
				form.setGoodsName(eList.get(i).getSetGoodsName());  //세트 상품명
				form.setTradingCount(eList.get(i).getSetGoodsCount());
				resultList.add(form);
			}
		}
		return resultList;
	}
	
	public Mycompany getMycompany() {
		Mycompany mycompany = docEstimateFormMapper.getMycompany();
		return mycompany;
	}
}
