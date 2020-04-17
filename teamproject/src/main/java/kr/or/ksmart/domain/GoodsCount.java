package kr.or.ksmart.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GoodsCount {
	
	private String goodsCode;
	private String goodsCategoryCode;
	private String goodsName;
	private String goodsBarcode;
	private int stockCount;
	private String goodsInputDate;
	private String goodsDesc;
	
	private String rentalDayPrice;
	private String priceInputDdate;
	private int priceInputStaffCode;
	
	private String goodsCategoryName;
	
	private String setCode;
	private String setName;
	private String setDayPrice;
	private String setInputDate;
	private int setInputStaffCode;
	
	private String setSerch;
	
	private String rentalPransCount;
	private String rentingCount;
	private int rentalCanCount;
}
