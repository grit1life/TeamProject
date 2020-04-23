package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class PriceSale {

	private int periodMax;
	private int periodMin;
	private double rateMax;
	private double rateMin;
	private int rentalFromPeriod;
	private double discountRate;	
	private String discountStartDay;
	private String inputStaffCode;
	private String inputDate;
	private String inputStaffName;
}
