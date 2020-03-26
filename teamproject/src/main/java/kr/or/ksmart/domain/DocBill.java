package kr.or.ksmart.domain;

public class DocBill {
	private String billCode;
	private String contractCode;
	private String billExpectedDate; //청구일자
	private String billDate;	//입금기한
	private String billPayday; //입금일자
	private String billPayNumber;  //청구회차
	private String contractTotalPrice;
	private String deliveryTel;
	private String customerCall;
	private String customerCompanyName;
	private String goodsName;
	private String setName;
	private int payMonth; //월별 납부 금액

	private int count;
	private int total;
	private String rentalFromDate;
	private String rentalToDate;
	public String getDeliveryTel() {
		return deliveryTel;
	}
	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String customerName;
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDeliveryDetailAddress() {
		return deliveryDetailAddress;
	}
	public void setDeliveryDetailAddress(String deliveryDetailAddress) {
		this.deliveryDetailAddress = deliveryDetailAddress;
	}
	public int getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(int payMonth) {
		this.payMonth = payMonth;
	}
	public String getBillPayNumber() {
		return billPayNumber;
	}
	public void setBillPayNumber(String billPayNumber) {
		this.billPayNumber = billPayNumber;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getBillExpectedDate() {
		return billExpectedDate;
	}
	public void setBillExpectedDate(String billExpectedDate) {
		this.billExpectedDate = billExpectedDate;
	}
	public String getBillDate() {
		return billDate;
	}
	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}
	public String getBillPayday() {
		return billPayday;
	}
	public void setBillPayday(String billPayday) {
		this.billPayday = billPayday;
	}
	public String getContractTotalPrice() {
		return contractTotalPrice;
	}
	public void setContractTotalPrice(String contractTotalPrice) {
		this.contractTotalPrice = contractTotalPrice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCall() {
		return customerCall;
	}
	public void setCustomerCall(String customerCall) {
		this.customerCall = customerCall;
	}
	public String getCustomerCompanyName() {
		return customerCompanyName;
	}
	public void setCustomerCompanyName(String customerCompanyName) {
		this.customerCompanyName = customerCompanyName;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getRentalFromDate() {
		return rentalFromDate;
	}
	public void setRentalFromDate(String rentalFromDate) {
		this.rentalFromDate = rentalFromDate;
	}
	public String getRentalToDate() {
		return rentalToDate;
	}
	public void setRentalToDate(String rentalToDate) {
		this.rentalToDate = rentalToDate;
	}
}
