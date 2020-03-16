package kr.or.ksmart.domain;

public class Customer {

	/********** 개인 고객  ***********/
	private String customerId;//개인 고객  아이디(코드)
	private String customerPw;//개인 고객  비밀번호
	private String customerName;//개인 고객  이름
	private String customerCall;//개인 고객  연락처
	private String customerEmail;//개인 고객 이메일
	private String zipCode; // 우편번호
	private String customerAddress;//개인 고객  기본주소
	private String customerAddress2;//개인 고객  상세주소
	private String customerClass;//개인 고객 등급(브론즈,실버,골드,플래티넘)
	private String customerLevel;//개인 고객 권한 (개인, 법인, 개인사업자)
	
	/********** 개인사업/법인 고객 ***********/
	private String customerComanyName;
	private String customerComanyPresident;
	private String customerCompanyCall;
	private String customerCompanyZipCode;
	private String customerCompanyAddress1;
	private String customerCompanyAddress2;
	private String customerCompanyEmail;
	private String customerCompanyHomepage;
	
	private String inputStaffCode;//입력인 직원 사번(코드)
	private String inputStaffName;//입력인 직원 이름
	private String inputDate; //입력날짜
	private String updateStaffCode;//수정인 직원 사번(코드)
	private String updateStaffName;//수정인 직원 이름
	private String updateDate; //수정날짜
	
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
	public String getCustomerComanyName() {
		return customerComanyName;
	}
	public void setCustomerComanyName(String customerComanyName) {
		this.customerComanyName = customerComanyName;
	}
	public String getCustomerComanyPresident() {
		return customerComanyPresident;
	}
	public void setCustomerComanyPresident(String customerComanyPresident) {
		this.customerComanyPresident = customerComanyPresident;
	}
	public String getCustomerCompanyCall() {
		return customerCompanyCall;
	}
	public void setCustomerCompanyCall(String customerCompanyCall) {
		this.customerCompanyCall = customerCompanyCall;
	}
	public String getCustomerCompanyZipCode() {
		return customerCompanyZipCode;
	}
	public void setCustomerCompanyZipCode(String customerCompanyZipCode) {
		this.customerCompanyZipCode = customerCompanyZipCode;
	}
	public String getCustomerCompanyAddress1() {
		return customerCompanyAddress1;
	}
	public void setCustomerCompanyAddress1(String customerCompanyAddress1) {
		this.customerCompanyAddress1 = customerCompanyAddress1;
	}
	public String getCustomerCompanyAddress2() {
		return customerCompanyAddress2;
	}
	public void setCustomerCompanyAddress2(String customerCompanyAddress2) {
		this.customerCompanyAddress2 = customerCompanyAddress2;
	}
	public String getCustomerCompanyEmail() {
		return customerCompanyEmail;
	}
	public void setCustomerCompanyEmail(String customerCompanyEmail) {
		this.customerCompanyEmail = customerCompanyEmail;
	}
	public String getCustomerCompanyHomepage() {
		return customerCompanyHomepage;
	}
	public void setCustomerCompanyHomepage(String customerCompanyHomepage) {
		this.customerCompanyHomepage = customerCompanyHomepage;
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
	public String getUpdateStaffCode() {
		return updateStaffCode;
	}
	public void setUpdateStaffCode(String updateStaffCode) {
		this.updateStaffCode = updateStaffCode;
	}
	public String getUpdateStaffName() {
		return updateStaffName;
	}
	public void setUpdateStaffName(String updateStaffName) {
		this.updateStaffName = updateStaffName;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPw=" + customerPw + ", customerName=" + customerName
				+ ", customerCall=" + customerCall + ", customerEmail=" + customerEmail + ", zipCode=" + zipCode
				+ ", customerAddress=" + customerAddress + ", customerAddress2=" + customerAddress2 + ", customerClass="
				+ customerClass + ", customerLevel=" + customerLevel + ", customerComanyName=" + customerComanyName
				+ ", customerComanyPresident=" + customerComanyPresident + ", customerCompanyCall="
				+ customerCompanyCall + ", customerCompanyZipCode=" + customerCompanyZipCode
				+ ", customerCompanyAddress1=" + customerCompanyAddress1 + ", customerCompanyAddress2="
				+ customerCompanyAddress2 + ", customerCompanyEmail=" + customerCompanyEmail
				+ ", customerCompanyHomepage=" + customerCompanyHomepage + ", inputStaffCode=" + inputStaffCode
				+ ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate + ", updateStaffCode="
				+ updateStaffCode + ", updateStaffName=" + updateStaffName + ", updateDate=" + updateDate
				+ ", getCustomerId()=" + getCustomerId() + ", getCustomerPw()=" + getCustomerPw()
				+ ", getCustomerName()=" + getCustomerName() + ", getCustomerCall()=" + getCustomerCall()
				+ ", getCustomerEmail()=" + getCustomerEmail() + ", getZipCode()=" + getZipCode()
				+ ", getCustomerAddress()=" + getCustomerAddress() + ", getCustomerAddress2()=" + getCustomerAddress2()
				+ ", getCustomerClass()=" + getCustomerClass() + ", getCustomerLevel()=" + getCustomerLevel()
				+ ", getCustomerComanyName()=" + getCustomerComanyName() + ", getCustomerComanyPresident()="
				+ getCustomerComanyPresident() + ", getCustomerCompanyCall()=" + getCustomerCompanyCall()
				+ ", getCustomerCompanyZipCode()=" + getCustomerCompanyZipCode() + ", getCustomerCompanyAddress1()="
				+ getCustomerCompanyAddress1() + ", getCustomerCompanyAddress2()=" + getCustomerCompanyAddress2()
				+ ", getCustomerCompanyEmail()=" + getCustomerCompanyEmail() + ", getCustomerCompanyHomepage()="
				+ getCustomerCompanyHomepage() + ", getInputStaffCode()=" + getInputStaffCode()
				+ ", getInputStaffName()=" + getInputStaffName() + ", getInputDate()=" + getInputDate()
				+ ", getUpdateStaffCode()=" + getUpdateStaffCode() + ", getUpdateStaffName()=" + getUpdateStaffName()
				+ ", getUpdateDate()=" + getUpdateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
