package kr.or.ksmart.mapper;

import kr.or.ksmart.domain.AsExchange;


public interface AsExchangeMapper {
	
	
	    //교환현황 업데이트(값가져오기)
		public AsExchange SelectForUpdate(String exchangeCode);
		//교환현황 업데이트(값 수정)
		public int eUpdate(AsExchange AsExchange);
		//삭제
		public int eDelete(String receptionCode);
	
	
	
	
	
	
	

}
