package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.Return;
import kr.or.ksmart.domain.ReturnSearchForm;
import kr.or.ksmart.mapper.ReturnMapper;

@Service
@Transactional
public class ReturnService {
	@Autowired
	private ReturnMapper returnMapper;
	
	public Pagination<List<Return>> getReturnSearchList(int currentPage, ReturnSearchForm rsf){
		int cnt = returnMapper.getReturnSearchListCnt(rsf);
		int column = (currentPage-1)*10;
		rsf.setColumn(column);
		List<Return> list = returnMapper.getReturnSearchList(rsf);

		Pagination<List<Return>> pagination
				= new Pagination<List<Return>>(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<Return>> getReturnCompleteSearchList(int currentPage, ReturnSearchForm rsf){
		int cnt = returnMapper.getReturnCompleteSearchListCnt(rsf);
		int column = (currentPage-1)*10;
		rsf.setColumn(column);
		List<Return> list = returnMapper.getReturnCompleteSearchList(rsf);
		
		Pagination<List<Return>> pagination
				= new Pagination<List<Return>>(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<Return>> getReturnList(int currentPage){
		int cnt = returnMapper.getReturnListCnt();
		int column = (currentPage-1)*10;
		List<Return> list = returnMapper.getReturnList(column);
		
		Pagination<List<Return>> pagination 
				= new Pagination<List<Return>>(list, currentPage, cnt);
				
		return pagination;
	}
	public Pagination<List<Return>> getReturnCompleteList(int currentPage){
		int cnt = returnMapper.getReturnCompleteListCnt();
		int column = (currentPage-1)*10;
		List<Return> list = returnMapper.getReturnCompleteList(column);
		
		Pagination<List<Return>> pagination 
				= new Pagination<List<Return>>(list, currentPage, cnt);
		
		return pagination;
	}
	public List<Return> ajaxReturnList(String contractCode){
		return returnMapper.ajaxReturnList(contractCode);
	}
	
	public int updateReturned(String rContractCode) {
		if(returnMapper.getReturnedCode(rContractCode) == null) {
			returnMapper.insertReturnedDate(rContractCode);
		}else {
			returnMapper.updateReturnedDate(rContractCode);
		}
		return returnMapper.updateReturned(rContractCode);
	}
	
	
	/**
	 * 렌탈 반납이 늦은 상품 입력
	 */
	@Scheduled(cron="0 0 1 * * *")
	public void insertLate() {
		returnMapper.insertLate();
	}
	
}
