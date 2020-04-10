package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class ReturnSearchForm {
	private String customerName;
	private String staffName;
	private String deliveryTel;
	private String setName;
	private String rentalFromDate;
	private String goodsName;
	private String rentalToDate;
	private int firstClmn;
	private int lastClmn;
}
