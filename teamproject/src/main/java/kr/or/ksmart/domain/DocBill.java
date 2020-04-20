package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DocBill {
	private String billCode;
	private String contractCode;
	private String billExpectedDate; //청구일자
	private String billDate;	//입금기한
	private String billPayday; //입금일자
	private int billPayNumber;  //청구회차
	private String contractTotalPrice;
	private String deliveryTel;
	private String customerCall;
	private String customerCompanyName;
	private String goodsName;
	private String setName;
	private int payMonth; //월별 납부 금액

	private int count;
	private int total;
	private String rentalFromDate;
	private String rentalToDate;
	private String staffName;
	private int firstClmn;
	private int lastClmn;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String customerName;
	private int column;

}
