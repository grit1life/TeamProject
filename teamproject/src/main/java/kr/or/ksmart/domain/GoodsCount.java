package kr.or.ksmart.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GoodsCount {
	
	private String goodsCode;
	private String[] goodsCodeArray;
	private String goodsCategoryCode;
	private String goodsName;
	private int stockCount;
	private String goodsDesc;
	
	private String rentalDayPrice;
	
	private String goodsCategoryName;
	
	private String setCode;
	private String setName;
	private String setDayPrice;

	private int rentalCanCount;
}
