package kr.or.ksmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mapper.PriceMapper;

@Service
@Transactional
public class PriceService {

	@Autowired
	private PriceMapper priceMapper;
	
	public double saleApplication(String period) {
		int periodInt = Integer.parseInt(period);
		int periodMax = priceMapper.period();
		//최대 할인율 적용 시 일일 때 오류 발생하므로 별도 계산
		if(periodInt>=periodMax) {
			return priceMapper.maxMinSaleApplication(periodMax);
		}else if(periodInt==1) {
			return priceMapper.maxMinSaleApplication(1);
		}else {
			return priceMapper.saleApplication(period);
		} 
	}
}
