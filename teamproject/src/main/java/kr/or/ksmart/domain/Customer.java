package kr.or.ksmart.domain;

public class Customer {

	private String customerId;//개인 고객 혹은 거래처 아이디(코드)
	private String customerPw;//개인 고객 혹은 거래처 비밀번호
	private String customerName;//개인 고객 혹은 거래처 담당자이름
	private String customerCall;//개인 고객 혹은 거래처 연락처
	private String customerEmail;//개인 고객 혹은 거래처 이메일
	private String zipCode; // 우편번호
	private String customerAddress;//개인 고객 혹은 거래처 기본주소
	private String customerAddress2;//개인 고객 혹은 거래처 상세주소
	private String customerClass;//개인 고객 혹은 거래처 등급(브론즈,실버,골드,플래티넘)
	private String customerLevel;//개인 고객 혹은 거래처 권한 (개인, 법인, 개인사업자)
	private String inputStaffCode;//입력인 직원 사번(코드)
	private String inputStaffName;//입력인 직원 이름
	private String inputDate; //입력날짜
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPw() {
		return customerPw;
	}
	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCall() {
		return customerCall;
	}
	public void setCustomerCall(String customerCall) {
		this.customerCall = customerCall;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerAddress2() {
		return customerAddress2;
	}
	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}
	public String getCustomerClass() {
		return customerClass;
	}
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	public String getInputStaffCode() {
		return inputStaffCode;
	}
	public void setInputStaffCode(String inputStaffCode) {
		this.inputStaffCode = inputStaffCode;
	}
	public String getInputStaffName() {
		return inputStaffName;
	}
	public void setInputStaffName(String inputStaffName) {
		this.inputStaffName = inputStaffName;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPw=" + customerPw + ", customerName=" + customerName
				+ ", customerCall=" + customerCall + ", customerEmail=" + customerEmail + ", zipCode=" + zipCode
				+ ", customerAddress=" + customerAddress + ", customerAddress2=" + customerAddress2 + ", customerClass="
				+ customerClass + ", customerLevel=" + customerLevel + ", inputStaffCode=" + inputStaffCode
				+ ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate + ", getCustomerId()="
				+ getCustomerId() + ", getCustomerPw()=" + getCustomerPw() + ", getCustomerName()=" + getCustomerName()
				+ ", getCustomerCall()=" + getCustomerCall() + ", getCustomerEmail()=" + getCustomerEmail()
				+ ", getZipCode()=" + getZipCode() + ", getCustomerAddress()=" + getCustomerAddress()
				+ ", getCustomerAddress2()=" + getCustomerAddress2() + ", getCustomerClass()=" + getCustomerClass()
				+ ", getCustomerLevel()=" + getCustomerLevel() + ", getInputStaffCode()=" + getInputStaffCode()
				+ ", getInputStaffName()=" + getInputStaffName() + ", getInputDate()=" + getInputDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}
