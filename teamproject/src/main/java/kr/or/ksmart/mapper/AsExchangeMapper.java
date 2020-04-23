package kr.or.ksmart.mapper;

import java.util.List;

import kr.or.ksmart.domain.AsExchange;



public interface AsExchangeMapper {
	
	
	    //교환현황 업데이트(값가져오기)
		public AsExchange SelectForUpdate(String exchangeCode);
		//교환현황 업데이트(값 수정)
		public int eUpdate(AsExchange AsExchange);
		//삭제
		public int eDelete(String receptionCode);
		// 검색 리스트 페이징 카운트
		public int findTotalCount();
		//검색 리스트
		public List<AsExchange> AsExchangeSearchList(  	String work
													   ,String workingSituation
													   ,String customerName 
													   ,String branchName
													   ,String staffName
													   ,String fromDate
													   ,String toDate
													   ,int startClmn
													   ,int endClmn
													   );
	
	
	
	
	
	
	

}
