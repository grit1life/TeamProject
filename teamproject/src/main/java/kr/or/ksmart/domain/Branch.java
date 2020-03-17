package kr.or.ksmart.domain;

public class Branch {
	
	
	private String branchCode;//지점코드
	private String branchName;//지점명
	private String staffId;// 지점장 코드
	private String staffName;// 지점장명
	private String branchPhone;//지점 연락처
	private String branchZipCode;//지점 우편번호
	private String branchAddress1;//지점 기본주소
	private String branchAddress2;//지점 상세주소
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
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getBranchPhone() {
		return branchPhone;
	}
	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}
	public String getBranchZipCode() {
		return branchZipCode;
	}
	public void setBranchZipCode(String branchZipCode) {
		this.branchZipCode = branchZipCode;
	}
	public String getBranchAddress1() {
		return branchAddress1;
	}
	public void setBranchAddress1(String branchAddress1) {
		this.branchAddress1 = branchAddress1;
	}
	public String getBranchAddress2() {
		return branchAddress2;
	}
	public void setBranchAddress2(String branchAddress2) {
		this.branchAddress2 = branchAddress2;
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
				+ ", staffName=" + staffName + ", branchPhone=" + branchPhone + ", branchZipCode=" + branchZipCode
				+ ", branchAddress1=" + branchAddress1 + ", branchAddress2=" + branchAddress2 + ", inputStaffCode="
				+ inputStaffCode + ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate
				+ ", getBranchCode()=" + getBranchCode() + ", getBranchName()=" + getBranchName() + ", getStaffId()="
				+ getStaffId() + ", getStaffName()=" + getStaffName() + ", getBranchPhone()=" + getBranchPhone()
				+ ", getBranchZipCode()=" + getBranchZipCode() + ", getBranchAddress1()=" + getBranchAddress1()
				+ ", getBranchAddress2()=" + getBranchAddress2() + ", getInputStaffCode()=" + getInputStaffCode()
				+ ", getInputStaffName()=" + getInputStaffName() + ", getInputDate()=" + getInputDate()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
	

}
