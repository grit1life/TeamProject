package kr.or.ksmart.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReturnSearchForm {
	private String customerName;
	private String staffName;
	private String deliveryTel;
	private String setName;
	private String rentalFromDate;
	private String goodsName;
	private String rentalToDate;
	private int column;
}
