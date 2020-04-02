package kr.or.ksmart.domain;

public class Outcome {
	private String branchName;
	private String staffName;
	private String year;
	private String month;
	private String sum;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Outcome [branchName=" + branchName + ", staffName=" + staffName + ", month=" + month + ", sum=" + sum
				+ "]";
	}
}
