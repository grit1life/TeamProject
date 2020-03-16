package kr.or.ksmart.domain;

public class Commute {
	private String staffName;
	private String commuteDate;
	private String commuteArrive;
	private String commuteLeave;
	private String commuteLateness;
	private String commuteEarlyleave;
	private String commuteHoliday;
	@Override
	public String toString() {
		return "Commute [staffName=" + staffName + ", commuteDate=" + commuteDate + ", commuteArrive=" + commuteArrive
				+ ", commuteLeave=" + commuteLeave + ", commuteLateness=" + commuteLateness + ", commuteEarlyleave="
				+ commuteEarlyleave + ", commuteHoliday=" + commuteHoliday + "]";
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getCommuteDate() {
		return commuteDate;
	}
	public void setCommuteDate(String commuteDate) {
		this.commuteDate = commuteDate;
	}
	public String getCommuteArrive() {
		return commuteArrive;
	}
	public void setCommuteArrive(String commuteArrive) {
		this.commuteArrive = commuteArrive;
	}
	public String getCommuteLeave() {
		return commuteLeave;
	}
	public void setCommuteLeave(String commuteLeave) {
		this.commuteLeave = commuteLeave;
	}
	public String getCommuteLateness() {
		return commuteLateness;
	}
	public void setCommuteLateness(String commuteLateness) {
		this.commuteLateness = commuteLateness;
	}
	public String getCommuteEarlyleave() {
		return commuteEarlyleave;
	}
	public void setCommuteEarlyleave(String commuteEarlyleave) {
		this.commuteEarlyleave = commuteEarlyleave;
	}
	public String getCommuteHoliday() {
		return commuteHoliday;
	}
	public void setCommuteHoliday(String commuteHoliday) {
		this.commuteHoliday = commuteHoliday;
	}
	
}
