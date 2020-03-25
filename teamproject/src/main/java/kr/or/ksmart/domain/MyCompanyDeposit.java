package kr.or.ksmart.domain;

public class MyCompanyDeposit {
	private String mydepositAccount;
	private String mydepositBank;
	private String mydepositAccountHolder;//예금주
	public String getMydepositAccount() {
		return mydepositAccount;
	}
	public void setMydepositAccount(String mydepositAccount) {
		this.mydepositAccount = mydepositAccount;
	}
	public String getMydepositBank() {
		return mydepositBank;
	}
	public void setMydepositBank(String mydepositBank) {
		this.mydepositBank = mydepositBank;
	}
	public String getMydepositAccountHolder() {
		return mydepositAccountHolder;
	}
	public void setMydepositAccountHolder(String mydepositAccountHolder) {
		this.mydepositAccountHolder = mydepositAccountHolder;
	}
}
