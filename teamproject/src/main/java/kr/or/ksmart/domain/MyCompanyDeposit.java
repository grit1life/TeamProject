package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MyCompanyDeposit {
	private String mydepositAccount;
	private String mydepositBank;
	private String mydepositAccountHolder;//예금주
}
