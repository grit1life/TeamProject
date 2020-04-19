package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DocContractForm {

	/* 계약서 */
	private String contractCode;
	private String contractNo;
	private String customerId;
	
	private String goodsCode;
	private String setCode;
	private String rentalCount;/* 주문갯수 */
	private String rentalFromDate;
	private String rentalToDate;
	private String rentalPeriod;
	private String saleCode;
	
	private String gradeName;
	private String effectivenessDate;/* 유효기간 */
	
	private String contractTotalPrice;
	private String deliveryWay;
	private String deliveryNumber;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String deliveryTel;

	private String customerName;

	private String contractDate;
	private String staffCode;
	private String inputStaffCode;
	private String inputDate;
	private String contractIsend;
	private String progressStatus;
	private String ispay;
	private String setGoodsName;
	private String setGoodsCount;
	private String customerCompanyName;
	private String customerCompanyPresident;
	private String customerCompanyCall;
	private String goodsName;
	private String setName;
	private String staffName;
	private String inputStaffName;
	private int count;
	private int total;
	private int firstClmn;
	private int lastClmn;
	
}
