package kr.or.ksmart.domain;

public class Branch {
	
	
	private String branchCode;//지점코드
	private String branchName;//지점명
	private String staffId;// 지점장 코드
	private String staffName;// 지점장명
	private String branchPhone;//지점 연락처
	private String branchAddress;//지점 주소
	private String inputStaffCode;//입력자 코드
	private String inputStaffName;//입력자명
	private String inputDate;//입력날짜
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchAddress() {
		return branchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
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
		return "Branch [branchCode=" + branchCode + ", branchName=" + branchName + ", staffId=" + staffId
				+ ", branchPhone=" + branchPhone + ", branchAddress=" + branchAddress + ", inputStaffCode="
				+ inputStaffCode + ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate
				+ ", getBranchCode()=" + getBranchCode() + ", getBranchName()=" + getBranchName() + ", getStaffId()="
				+ getStaffId() + ", getBranchPhone()=" + getBranchPhone() + ", getBranchAddress()=" + getBranchAddress()
				+ ", getInputStaffCode()=" + getInputStaffCode() + ", getInputStaffName()=" + getInputStaffName()
				+ ", getInputDate()=" + getInputDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
