package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.mapper.DocContractFormMapper;

@Service
@Transactional
public class DocContractFormService {
	
	@Autowired
	private DocContractFormMapper docContractFormMapper;
	
	public List<DocContractForm> getContractSchedulerList(){
		List<DocContractForm> list = docContractFormMapper.getContractSchedulerList();
		return list;
	}
	
	public Map<String, Object> getContractList(int currentPage){
		int cnt = docContractFormMapper.getContractListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<DocContractForm> list = docContractFormMapper.getContractList(firstClmn, lastClmn);
		
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
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}
	public Map<String, Object> getContractSearchList(int currentPage, DocContractForm docContractForm){
		int cnt = docContractFormMapper.getContractSearchListCnt(docContractForm);
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		docContractForm.setFirstClmn(firstClmn);
		docContractForm.setLastClmn(lastClmn);
		List<DocContractForm> list = docContractFormMapper.getContractSearchList(docContractForm);
		
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
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}
	
	public List<DocContractForm> getContractForm(String contractCode){
		List<DocContractForm> list = docContractFormMapper.getContractForm(contractCode);
		
		List<DocContractForm> resultList = new ArrayList<DocContractForm>();
		for(int i=0; i<list.size(); i++) {
			if(i==0) {
				resultList.add(list.get(i));
			}else if(!list.get(i).getContractNo().equals( list.get(i-1).getContractNo() )) {
				if(list.get(i).getSetCode()!=null) {
					resultList.add(list.get(i));
				}else {
					resultList.add(list.get(i));
				}
			}
			if(list.get(i).getSetCode()!=null) {
				DocContractForm form = new DocContractForm();
				form.setSetCode(list.get(i).getSetCode());
				form.setSetGoodsName(list.get(i).getSetGoodsName());  //세트 상품명
				form.setRentalCount(list.get(i).getSetGoodsCount());
				resultList.add(form);
			}
		}
		return resultList;
	}
}
