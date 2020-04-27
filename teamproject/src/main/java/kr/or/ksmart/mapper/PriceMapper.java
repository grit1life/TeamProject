package kr.or.ksmart.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.PriceGoods;
import kr.or.ksmart.domain.PriceSale;

@Mapper
public interface PriceMapper {

	public int discountInsert(List<PriceSale> priceSaleList);
	public List<String> discountStartDay();
	public List<PriceSale> disDetailsList(String discountStartDay);
	public int period();
	public double maxMinSaleApplication(int period);
	public double saleApplication(String period);
	public int discountDelete(String discountStartDay);
	public List<PriceSale> goodsPriceList(PriceGoods priceGoods);
	public int goodsPriceInsert(PriceGoods priceGoods);
	public int goodsPriceUpdate(PriceGoods priceGoods);
	public String goodsPriceExistence(PriceGoods priceGoods);
	
}
