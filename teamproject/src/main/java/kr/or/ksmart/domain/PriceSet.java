package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class PriceSet {
	private String setCode;
	private String setName;
	private String setDayPrice;
	private String inputDate;
	private String inputStaffCode;
}
