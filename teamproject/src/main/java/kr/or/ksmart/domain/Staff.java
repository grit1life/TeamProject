package kr.or.ksmart.domain;

public class Staff {

	private String staffCode;
	private String staffPw;
	private String staffName;
	private String staffBirth;
	private String staffTell;
	private String staffEmail;
	private String inputStaffId;
	private String inputStaffName;
	private String inputDate;
	private String staffLevel;
	
	private String staffFromPeriod;
	private String staffToPeriod;
	private String branchCode;
	private String staffPosition;
	
	private String branchPhone;
	private String branchAddress;
	private String branchName;
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffPw() {
		return staffPw;
	}
	public void setStaffPw(String staffPw) {
		this.staffPw = staffPw;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffBirth() {
		return staffBirth;
	}
	public void setStaffBirth(String staffBirth) {
		this.staffBirth = staffBirth;
	}
	public String getStaffTell() {
		return staffTell;
	}
	public void setStaffTell(String staffTell) {
		this.staffTell = staffTell;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getInputStaffId() {
		return inputStaffId;
	}
	public void setInputStaffId(String inputStaffId) {
		this.inputStaffId = inputStaffId;
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
	public String getStaffLevel() {
		return staffLevel;
	}
	public void setStaffLevel(String staffLevel) {
		this.staffLevel = staffLevel;
	}
	public String getStaffFromPeriod() {
		return staffFromPeriod;
	}
	public void setStaffFromPeriod(String staffFromPeriod) {
		this.staffFromPeriod = staffFromPeriod;
	}
	public String getStaffToPeriod() {
		return staffToPeriod;
	}
	public void setStaffToPeriod(String staffToPeriod) {
		this.staffToPeriod = staffToPeriod;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getStaffPosition() {
		return staffPosition;
	}
	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
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
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Override
	public String toString() {
		return "Staff [staffCode=" + staffCode + ", staffPw=" + staffPw + ", staffName=" + staffName + ", staffBirth="
				+ staffBirth + ", staffTell=" + staffTell + ", staffEmail=" + staffEmail + ", inputStaffId="
				+ inputStaffId + ", inputStaffName=" + inputStaffName + ", inputDate=" + inputDate + ", staffLevel="
				+ staffLevel + ", staffFromPeriod=" + staffFromPeriod + ", staffToPeriod=" + staffToPeriod
				+ ", branchCode=" + branchCode + ", staffPosition=" + staffPosition + ", branchPhone=" + branchPhone
				+ ", branchAddress=" + branchAddress + ", branchName=" + branchName + "]";
	}
	
	
	

}
