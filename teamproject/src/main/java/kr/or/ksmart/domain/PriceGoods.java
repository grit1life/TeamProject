package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class PriceGoods {

	private String goodsCategoryName;
	private String goodsCategoryCode;
	private String goodsCode;
	private String goodsName;
	private String goodsDesc;
	private String rentalDayPrice;
	private String rentalDayPriceExistence;


}
