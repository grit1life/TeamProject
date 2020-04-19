package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Shipment {
	private String shipmentCode;
	private String billCode;
	private String contractNo;
	private String shipmentDate;
	private String rentalCount;
	private String inputStaffId;
	private String inputDate;
	private String updateStaffId;
	private String updateDate;
	private String goodsName;
	private String setGoodsCount;
	private String setGoodsName;
	private String customerName;
	private String customerCompanyName;
	private int count;
	private String rentalFromDate;
	private String rentalToDate;
	private String deliveryTel;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private int column;
	private String shipmentCompleteDate;
	private String staffName;
	private String customerCall;
	private String setName;
}
