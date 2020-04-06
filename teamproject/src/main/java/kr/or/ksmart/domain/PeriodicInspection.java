package kr.or.ksmart.domain;

public class PeriodicInspection {
	
	
	private String checkCode; //점검번호
	private String branchCode; //점검 지점코드
	private String branchName; //점검 지점명
	private String customerId;// 고객 아이디
	private String customerName;// 고객 이름
	private String customerLevel;// 고객 권한
	private String customerCall;// 고객 연락처
	private String zipCode; // 우편번호
	private String customerAddress;//개인 고객  기본주소
	private String customerAddress2;//개인 고객  상세주소
	private String staffId; //점검 기사 아이디
	private String staffName; //점검 기사 이름
	private String checkDate;//점검일

	private String productStatus; //제품상태
	private String checkContents; //점검내용
	
	/* 계약서 */
	private String contractCode; // 계약서 코드
	private String contractNo;
	
	
	/*상품*/
	private String goodsCode; // 상품코드
	private String goodsName; // 상품명

	
	private String inputStaffCode;//입력인 직원 사번(코드)
	private String inputStaffName;//입력인 직원 이름
	private String inputDate; //입력날짜
	private String updateStaffCode;//수정인 직원 사번(코드)
	private String updateStaffName;//수정인 직원 이름
	private String updateDate; //수정날짜
	
	
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getCustomerLevel() {
		return customerLevel;
	}
	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}
	public String getCustomerCall() {
		return customerCall;
	}
	public void setCustomerCall(String customerCall) {
		this.customerCall = customerCall;
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
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getCheckContents() {
		return checkContents;
	}
	public void setCheckContents(String checkContents) {
		this.checkContents = checkContents;
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
		return "PeriodicInspection [checkCode=" + checkCode + ", branchCode=" + branchCode + ", branchName="
				+ branchName + ", customerId=" + customerId + ", customerName=" + customerName + ", customerLevel="
				+ customerLevel + ", customerCall=" + customerCall + ", zipCode=" + zipCode + ", customerAddress="
				+ customerAddress + ", customerAddress2=" + customerAddress2 + ", staffId=" + staffId + ", staffName="
				+ staffName + ", checkDate=" + checkDate + ", productStatus=" + productStatus + ", checkContents="
				+ checkContents + ", contractCode=" + contractCode + ", contractNo=" + contractNo + ", goodsCode="
				+ goodsCode + ", goodsName=" + goodsName + ", inputStaffCode=" + inputStaffCode + ", inputStaffName="
				+ inputStaffName + ", inputDate=" + inputDate + ", updateStaffCode=" + updateStaffCode
				+ ", updateStaffName=" + updateStaffName + ", updateDate=" + updateDate + ", getGoodsName()="
				+ getGoodsName() + ", getCustomerLevel()=" + getCustomerLevel() + ", getCustomerCall()="
				+ getCustomerCall() + ", getZipCode()=" + getZipCode() + ", getCustomerAddress()="
				+ getCustomerAddress() + ", getCustomerAddress2()=" + getCustomerAddress2() + ", getContractNo()="
				+ getContractNo() + ", getGoodsCode()=" + getGoodsCode() + ", getBranchName()=" + getBranchName()
				+ ", getCustomerName()=" + getCustomerName() + ", getStaffName()=" + getStaffName()
				+ ", getCustomerId()=" + getCustomerId() + ", getCheckCode()=" + getCheckCode() + ", getContractCode()="
				+ getContractCode() + ", getBranchCode()=" + getBranchCode() + ", getStaffId()=" + getStaffId()
				+ ", getCheckDate()=" + getCheckDate() + ", getProductStatus()=" + getProductStatus()
				+ ", getCheckContents()=" + getCheckContents() + ", getInputStaffCode()=" + getInputStaffCode()
				+ ", getInputStaffName()=" + getInputStaffName() + ", getInputDate()=" + getInputDate()
				+ ", getUpdateStaffCode()=" + getUpdateStaffCode() + ", getUpdateStaffName()=" + getUpdateStaffName()
				+ ", getUpdateDate()=" + getUpdateDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
