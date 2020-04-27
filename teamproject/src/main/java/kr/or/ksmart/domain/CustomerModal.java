package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class CustomerModal {

	/********** 개인 고객  ***********/
	private String customerId;//개인 고객  아이디(코드)
	private String customerName;//개인 고객  이름
	private String customerCall;//개인 고객  연락처
	private String customerEmail;//개인 고객 이메일
	private String zipCode; // 우편번호
	private String customerAddress;//개인 고객  기본주소
	private String customerAddress2;//개인 고객  상세주소
	private String customerClass;//개인 고객 등급(브론즈,실버,골드,플래티넘)
	private String customerDiscount;
}
