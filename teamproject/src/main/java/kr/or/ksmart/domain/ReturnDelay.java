package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReturnDelay extends DocContractForm {
	private String returnedDate;
	private String returnedLate;
	private String customerCall;
	private String customerAddress;
	private String customerAddress2;
	private String customerCompanyName;
	private String customerCompanyCall;
	private String customerCompanyAddress1;
	private String customerCompanyAddress2;
}
