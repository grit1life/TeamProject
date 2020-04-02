package kr.or.ksmart.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.PriceSale;

@Mapper
public interface PriceMapper {

	public int period();
	public double maxMinSaleApplication(int period);
	public double saleApplication(String period);
}
