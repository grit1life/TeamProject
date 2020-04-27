package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class PriceGoods {

	private String goodsCategoryName;
	private String goodsCategoryCode;
	private String goodsCode;
	private String goodsName;
	private String goodsDesc;
	private int rentalDayPrice;
	private String rentalDayPriceExistence;
	private String inputStaffCode;


}
