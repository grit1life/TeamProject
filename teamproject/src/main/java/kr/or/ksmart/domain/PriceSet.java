package kr.or.ksmart.domain;

public class PriceSet {
	private String setCode;
	private String setName;
	private String setDayPrice;
	private String inputDate;
	private String inputStaffCode;
	@Override
	public String toString() {
		return "PriceSet [setCode=" + setCode + ", setName=" + setName + ", setDayPrice=" + setDayPrice + ", inputDate="
				+ inputDate + ", inputStaffCode=" + inputStaffCode + "]";
	}
	public String getSetCode() {
		return setCode;
	}
	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getSetDayPrice() {
		return setDayPrice;
	}
	public void setSetDayPrice(String setDayPrice) {
		this.setDayPrice = setDayPrice;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getInputStaffCode() {
		return inputStaffCode;
	}
	public void setInputStaffCode(String inputStaffCode) {
		this.inputStaffCode = inputStaffCode;
	}
}
