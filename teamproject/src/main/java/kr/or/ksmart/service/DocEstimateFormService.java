package kr.or.ksmart.service;

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
	
	public List<DocEstimateForm> getAjaxFormList(Map<String, Object> map){
		String estimateCode = (String) map.get("estimateCode");
		List<DocEstimateForm> list = docEstimateFormMapper.getAjaxFormList(estimateCode);
		return list;
	}
	
	public DocEstimateForm getEstimateForm(String estimateCode, String no) {
		DocEstimateForm docEstimateForm = docEstimateFormMapper.getEstimateForm(estimateCode, no);
		return docEstimateForm;
	}
	
	public Mycompany getMycompany() {
		Mycompany mycompany = docEstimateFormMapper.getMycompany();
		return mycompany;
	}
}
