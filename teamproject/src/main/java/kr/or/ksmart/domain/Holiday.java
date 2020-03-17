package kr.or.ksmart.domain;

public class Holiday {
	private String holidayCode;
	private String staffId;
	private String holidayDate;
	private String holidaySort;
	@Override
	public String toString() {
		return "Holiday [holidayCode=" + holidayCode + ", staffId=" + staffId + ", holidayDate=" + holidayDate
				+ ", holidaySort=" + holidaySort + "]";
	}
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
	public String getHolidayDate() {
		return holidayDate;
	}
	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}
	public String getHolidaySort() {
		return holidaySort;
	}
	public void setHolidaySort(String holidaySort) {
		this.holidaySort = holidaySort;
	}
}
