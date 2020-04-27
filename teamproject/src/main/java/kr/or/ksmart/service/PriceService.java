package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.PriceGoods;
import kr.or.ksmart.domain.PriceSale;
import kr.or.ksmart.mapper.PriceMapper;

@Service
@Transactional
public class PriceService {

	@Autowired
	private PriceMapper priceMapper;
	
	public int goodsPriceInsert(PriceGoods priceGoods,HttpSession session) {
		
		String staffId = (String)session.getAttribute("staffId");
		priceGoods.setInputStaffCode(staffId);
		
		String goodsPrice  = priceMapper.goodsPriceExistence(priceGoods);
		
		if(goodsPrice==null) {
			priceMapper.goodsPriceInsert(priceGoods);
		}else {
			priceMapper.goodsPriceUpdate(priceGoods);
		}	
		return 0;
	}
	
	public int discountInsert(Map<String, Object> discountInsertMap,HttpSession session){
		System.out.println(discountInsertMap+"<-param/service");
		String periodListS = discountInsertMap.get("periodList").toString();
		String[] periodList = periodListS.replace("[","").replace("]","").split(", ");
		String[] rateList = discountInsertMap.get("rateList").toString().replace("[","").replace("]","").split(", ");
		String discountStartDay = discountInsertMap.get("discountStartDay").toString();
		String staffId = (String)session.getAttribute("staffId");
		
		List<PriceSale> priceSaleList = new ArrayList<PriceSale>();
		
		for(int i=0; i<periodList.length; i++) {
			PriceSale priceSale = new PriceSale();
			priceSale.setRentalFromPeriod(Integer.parseInt(periodList[i]));
			priceSale.setDiscountRate(Double.parseDouble(rateList[i]));
			priceSale.setDiscountStartDay(discountStartDay);
			priceSale.setInputStaffCode(staffId);
			priceSaleList.add(priceSale);
		}
		
		return priceMapper.discountInsert(priceSaleList);
	}
	public List<String> discountStartDay(){
		return priceMapper.discountStartDay();
	}
	public List<PriceSale> disDetailsList(String discountStartDay){
		return priceMapper.disDetailsList(discountStartDay);
	}
	
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
	
	public int discountDelete(String discountStartDay) {
		return priceMapper.discountDelete(discountStartDay);
	};
	
	public List<PriceSale> goodsPriceList(PriceGoods priceGoods) {
		return priceMapper.goodsPriceList(priceGoods);
	};
}
