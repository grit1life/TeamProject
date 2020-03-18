package kr.or.ksmart.domain;

public class PeriodicInspection {
	
	
	private String checkCode; //점검번호
	private String contractCode; // 계약서 코드
	private String branchCode; //점검 지점코드
	private String customerId;// 고객 아이디
	private String staffId; //점검 기사 아이디
	private String checkDate;//점검일
	private String productStatus; //제품상태
	private String checkContents; //점검내용
	
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
		return "PeriodicInspection [checkCode=" + checkCode + ", contractCode=" + contractCode + ", branchCode="
				+ branchCode + ", customerId=" + customerId + ", staffId=" + staffId + ", checkDate=" + checkDate
				+ ", productStatus=" + productStatus + ", checkContents=" + checkContents + ", inputStaffCode="
				+ inputStaffCode + ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate
				+ ", updateStaffCode=" + updateStaffCode + ", updateStaffName=" + updateStaffName + ", updateDate="
				+ updateDate + ", getCustomerId()=" + getCustomerId() + ", getCheckCode()=" + getCheckCode()
				+ ", getContractCode()=" + getContractCode() + ", getBranchCode()=" + getBranchCode()
				+ ", getStaffId()=" + getStaffId() + ", getCheckDate()=" + getCheckDate() + ", getProductStatus()="
				+ getProductStatus() + ", getCheckContents()=" + getCheckContents() + ", getInputStaffCode()="
				+ getInputStaffCode() + ", getInputStaffName()=" + getInputStaffName() + ", getInputDate()="
				+ getInputDate() + ", getUpdateStaffCode()=" + getUpdateStaffCode() + ", getUpdateStaffName()="
				+ getUpdateStaffName() + ", getUpdateDate()=" + getUpdateDate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
