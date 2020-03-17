package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.mapper.CommuteMapper;

@Service
@Transactional
public class CommuteService {
	
	@Autowired
	private CommuteMapper commuteMapper;
	
	public Map<String, Object> CommuteList(String staffId, int currentPage){
		int startClmn = (currentPage-1) * 10;
		int clmnCnt = 10;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("staffId", staffId);
		paramMap.put("startClmn", startClmn);
		paramMap.put("clmnCnt", clmnCnt);
		List<Commute> cList = commuteMapper.commuteList(paramMap);
		
		int startPage = currentPage - 5;
		if(startPage <= 5 ) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int pageCnt = commuteMapper.getCommuteListCnt(staffId);
		int lastPage = pageCnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("startPage", startPage);
		resultMap.put("endPage", endPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("currentPage", currentPage);
		resultMap.put("cList", cList);
		
		return resultMap;
	}
}
