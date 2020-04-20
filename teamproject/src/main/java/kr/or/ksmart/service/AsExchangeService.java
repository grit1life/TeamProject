package kr.or.ksmart.service;

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
		public int pUpdate(AsExchange AsExchange) {
			
			return AsExchangeMapper.eUpdate(AsExchange);
		}

}
