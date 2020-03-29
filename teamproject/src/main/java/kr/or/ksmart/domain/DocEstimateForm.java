package kr.or.ksmart.domain;

public class DocEstimateForm extends DocEstimate {

	private String customerName;
	private String customerAddress;
	private String customerAddress2;
	private String customerCompanyName;
	private String goodsName;
	private String setName;
	private String customerCall;
	private String setGoodsName;
	private int rentalDayPrice; //단품가격
	private int setDayPrice; //세트가격
	private String setGoodsCount;
	private String staffName;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getSetGoodsCount() {
		return setGoodsCount;
	}
	public void setSetGoodsCount(String setGoodsCount) {
		this.setGoodsCount = setGoodsCount;
	}
	public int getSetDayPrice() {
		return setDayPrice;
	}
	public void setSetDayPrice(int setDayPrice) {
		this.setDayPrice = setDayPrice;
	}
	public int getRentalDayPrice() {
		return rentalDayPrice;
	}
	public void setRentalDayPrice(int rentalDayPrice) {
		this.rentalDayPrice = rentalDayPrice;
	}
	public String getSetGoodsName() {
		return setGoodsName;
	}
	public void setSetGoodsName(String setGoodsName) {
		this.setGoodsName = setGoodsName;
	}
	public String getCustomerCall() {
		return customerCall;
	}
	public void setCustomerCall(String customerCall) {
		this.customerCall = customerCall;
	}
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getCustomerCompanyName() {
		return customerCompanyName;
	}
	public void setCustomerCompanyName(String customerCompanyName) {
		this.customerCompanyName = customerCompanyName;
	}
}
