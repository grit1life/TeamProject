package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Grade {
	private String customerClass;
	private int gradeCnt;
	private String customerName;
	private String customerCompanyName;
	private String customerCall;
	private String customerAddress;
	private String customerAddress2;
	private String customerCompanyCall;
	private String customerCompanyAddress1;
	private String customerCompanyAddress2;
	private String total;
}
