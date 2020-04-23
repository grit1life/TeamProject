package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.mapper.AsExchangeMapper;




@Service
@Transactional
public class AsExchangeService {
	
	
	
	@Autowired
	private AsExchangeMapper AsExchangeMapper;
	
	
	
		//상세보기	
		public AsExchange SelectForUpdate(String exchangeCode) {
			
			return AsExchangeMapper.SelectForUpdate(exchangeCode);
		}
		
		//값 수정
		public int eUpdate(AsExchange AsExchange) {
			
			return AsExchangeMapper.eUpdate(AsExchange);
		}
		// 삭제	
		public int eDelte(String receptionCode) {
				
			return AsExchangeMapper.eDelete(receptionCode);
		}
		
		
		// 검색 리스트(페이징 포함)	
		public Map<String, Object> AsExchangeSearchList(
					String work
				   ,String workingSituation
				   ,String customerName 
				   ,String branchName
				   ,String staffName
				   ,String fromDate
				   ,String toDate
				   ,int currentPage
					    ){
				
				int cnt = AsExchangeMapper.findTotalCount();
				int firstClmn = (currentPage-1)*10;
				int lastClmn = firstClmn +10;
				List<AsExchange> eList = AsExchangeMapper.AsExchangeSearchList(work,workingSituation, customerName, branchName, staffName, fromDate, toDate, firstClmn, lastClmn);
				
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
				map.put("AsExchangeList", eList);
				map.put("currentPage", currentPage);
				map.put("startPage", startPage);
				map.put("endPage", endPage);
				map.put("lastPage", lastPage);

				
				return map;
			}

}
