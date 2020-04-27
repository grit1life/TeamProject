package kr.or.ksmart.domain;

import lombok.Data;

@Data
public class CompanyModal {

	/********** 법인 고객  ***********/
	private String customerId;//법인 고객  아이디(코드)
	private String customerCompanyName;//법인 고객  이름
	private String customerCompanyCall;//법인 고객  연락처
	private String customerCompanyEmail;//법인 고객 이메일
	private String customerCompanyzipCode; // 우편번호
	private String customerCompanyAddress;//법인 고객  기본주소
	private String customerCompanyAddress2;//법인 고객  상세주소
	private String customerClass;//법인 고객 등급(브론즈,실버,골드,플래티넘)
	private String customerDiscount;
	private String customerName;//법인 담당자  이름
	private String customerCall;//법인 담당자  연락처
}
