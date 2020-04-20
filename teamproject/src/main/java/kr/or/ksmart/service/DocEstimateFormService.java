package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.PriceSet;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.mapper.DocEstimateFormMapper;

@Service
@Transactional
public class DocEstimateFormService {
	
	@Autowired
	private DocEstimateFormMapper docEstimateFormMapper;
	

	/**
	 * 직원 이름 
	 * @return
	 */
	public List<Staff> getStaffNameList(){
		List<Staff> staffList = docEstimateFormMapper.getStaffNameList();
		return staffList;
	}
	

	/**
	 * 세트네임
	 * @return
	 */
	public List<PriceSet> getSetNameList(){ 
		List<PriceSet> setList = docEstimateFormMapper.getSetNameList();
		return setList;
	}
	
	public List<Goods> getGoodsNameList(){
		List<Goods> goodsList = docEstimateFormMapper.getGoodsNameList();
		return goodsList;
	}
	
	public Pagination<List<DocEstimateForm>> getEstimateList(int currentPage){
		int cnt = docEstimateFormMapper.getEstimateListCnt();
		int column = (currentPage-1)*10;
		List<DocEstimateForm> list = docEstimateFormMapper.getEstimateList(column);
		Pagination<List<DocEstimateForm>> p = new Pagination<List<DocEstimateForm>>(list, currentPage, cnt);
	
		return p;
	}
	public Pagination<List<DocEstimateForm>> getEstimateSearchList(int currentPage, DocEstimateForm docEstimateForm){
		int cnt = docEstimateFormMapper.getEstimateSearchListCnt();
		int column = (currentPage-1)*10;
		docEstimateForm.setColumn(column);
		List<DocEstimateForm> eList = docEstimateFormMapper.getEstimateSearchList(docEstimateForm);
		
		Pagination<List<DocEstimateForm>> p = new Pagination<List<DocEstimateForm>>
					(eList, currentPage, cnt);
		
		return p;
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
