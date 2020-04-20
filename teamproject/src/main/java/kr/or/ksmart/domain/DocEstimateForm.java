package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DocEstimateForm extends DocEstimate {

	private String customerName;
	private String customerAddress;
	private String customerAddress2;
	private String customerCompanyName;
	private String goodsName;
	private String setName;
	private String customerCall;
	private String setGoodsName;
	private int rentalDayPrice; //단품가격
	private int setDayPrice; //세트가격
	private String setGoodsCount;
	private String staffName;
	private int count;
	private int column;
}
