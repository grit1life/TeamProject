package kr.or.ksmart.domain;

public class Holiday {
	private String holidayCode;
	private String staffName;
	private String staffId;
	private String holidayFromDate;
	private String holidayToDate;
	private String holidaySort;
	public String getHolidayCode() {
		return holidayCode;
	}
	public void setHolidayCode(String holidayCode) {
		this.holidayCode = holidayCode;
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
	public String getHolidayFromDate() {
		return holidayFromDate;
	}
	public void setHolidayFromDate(String holidayFromDate) {
		this.holidayFromDate = holidayFromDate;
	}
	public String getHolidayToDate() {
		return holidayToDate;
	}
	public void setHolidayToDate(String holidayToDate) {
		this.holidayToDate = holidayToDate;
	}
	public String getHolidaySort() {
		return holidaySort;
	}
	public void setHolidaySort(String holidaySort) {
		this.holidaySort = holidaySort;
	}
	@Override
	public String toString() {
		return "Holiday [holidayCode=" + holidayCode + ", staffName=" + staffName + ", staffId=" + staffId
				+ ", holidayFromDate=" + holidayFromDate + ", holidayToDate=" + holidayToDate + ", holidaySort="
				+ holidaySort + "]";
	}
}
