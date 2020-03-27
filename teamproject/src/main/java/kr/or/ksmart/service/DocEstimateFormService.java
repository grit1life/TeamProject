package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.mapper.DocEstimateFormMapper;

@Service
@Transactional
public class DocEstimateFormService {
	
	@Autowired
	private DocEstimateFormMapper docEstimateFormMapper;
	
	public Map<String, Object> getEstimateList(int currentPage){
		int cnt = docEstimateFormMapper.getEstimateListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<DocEstimateForm> eList = docEstimateFormMapper.getEstimateList(firstClmn, lastClmn);
		
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("eList", eList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}

	public List<DocEstimateForm> getCusEstimateList(String cId){
		List<DocEstimateForm> eList  = docEstimateFormMapper.getCusEstimateList(cId);
		return eList;
	}
	/*
	public List<DocEstimateForm> getAjaxFormList(Map<String, Object> map){
		String estimateCode = (String) map.get("estimateCode");
		List<DocEstimateForm> list = docEstimateFormMapper.getAjaxFormList(estimateCode);
		return list;
	}*/
	
	public Map<String, Object> getEstimateForm(String estimateCode) {
		List<DocEstimateForm> eList = docEstimateFormMapper.getEstimateForm(estimateCode);
		int cnt = docEstimateFormMapper.getEstimateFormCnt(estimateCode);

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
		int page = cnt/10 + 1;
		int remainClmn = 10 - cnt/10;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultList", resultList);
		map.put("page", page);
		map.put("remainClmn", remainClmn);
		map.put("cnt", cnt);
		
		return map;
	}
	
	public Mycompany getMycompany() {
		Mycompany mycompany = docEstimateFormMapper.getMycompany();
		return mycompany;
	}
}
