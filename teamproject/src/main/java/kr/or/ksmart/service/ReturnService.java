package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Return;
import kr.or.ksmart.domain.ReturnSearchForm;
import kr.or.ksmart.mapper.ReturnMapper;

@Service
@Transactional
public class ReturnService {
	@Autowired
	private ReturnMapper returnMapper;
	
	public Map<String, Object> getReturnSearchList(int currentPage, ReturnSearchForm rsf){
		int cnt = returnMapper.getReturnSearchListCnt(rsf);
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		rsf.setFirstClmn(firstClmn);
		rsf.setLastClmn(lastClmn);
		List<Return> list = returnMapper.getReturnSearchList(rsf);
		
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
	public Map<String, Object> getReturnCompleteSearchList(int currentPage, ReturnSearchForm rsf){
		int cnt = returnMapper.getReturnCompleteSearchListCnt(rsf);
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		rsf.setFirstClmn(firstClmn);
		rsf.setLastClmn(lastClmn);
		List<Return> list = returnMapper.getReturnCompleteSearchList(rsf);
		
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
	public Map<String, Object> getReturnList(int currentPage){
		int cnt = returnMapper.getReturnListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Return> list = returnMapper.getReturnList(firstClmn, lastClmn);
		
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
	public Map<String, Object> getReturnCompleteList(int currentPage){
		int cnt = returnMapper.getReturnCompleteListCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Return> list = returnMapper.getReturnCompleteList(firstClmn, lastClmn);
		
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
	public List<Return> ajaxReturnList(String contractCode){
		return returnMapper.ajaxReturnList(contractCode);
	}
	
	public int returnedUpdate(String rContractCode) {
		return returnMapper.returnedUpdate(rContractCode);
	}
}
