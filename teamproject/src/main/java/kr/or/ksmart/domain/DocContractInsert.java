package kr.or.ksmart.domain;

import java.util.Arrays;

public class DocContractInsert {

	/* 계약서 */
	private String contractCode;
	private String contractNo;
	
	private String customerId;
	private String gradeName;
	
	private String rentalFromDate;
	private String rentalToDate;
	private String rentalPeriod;
	
	private String deliveryWay;
	private String deliveryNumber;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String deliveryTel;
	
	private String staffCode;
	
	private String[] goodsCode;
	private String[] setCode;
	private String[] rentalCount;/* 주문갯수 */
		
	private String contractTotalPrice;

	private String inputStaffCode;
	private String inputDate;
	public String getContractCode() {
		return contractCode;
	}
	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
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
	public String getRentalPeriod() {
		return rentalPeriod;
	}
	public void setRentalPeriod(String rentalPeriod) {
		this.rentalPeriod = rentalPeriod;
	}
	public String getDeliveryWay() {
		return deliveryWay;
	}
	public void setDeliveryWay(String deliveryWay) {
		this.deliveryWay = deliveryWay;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
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
	public String getDeliveryTel() {
		return deliveryTel;
	}
	public void setDeliveryTel(String deliveryTel) {
		this.deliveryTel = deliveryTel;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String[] getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String[] goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String[] getSetCode() {
		return setCode;
	}
	public void setSetCode(String[] setCode) {
		this.setCode = setCode;
	}
	public String[] getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(String[] rentalCount) {
		this.rentalCount = rentalCount;
	}
	public String getContractTotalPrice() {
		return contractTotalPrice;
	}
	public void setContractTotalPrice(String contractTotalPrice) {
		this.contractTotalPrice = contractTotalPrice;
	}
	public String getInputStaffCode() {
		return inputStaffCode;
	}
	public void setInputStaffCode(String inputStaffCode) {
		this.inputStaffCode = inputStaffCode;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	@Override
	public String toString() {
		return "DocContractInsert [contractCode=" + contractCode + ", contractNo=" + contractNo + ", customerId="
				+ customerId + ", gradeName=" + gradeName + ", rentalFromDate=" + rentalFromDate + ", rentalToDate="
				+ rentalToDate + ", rentalPeriod=" + rentalPeriod + ", deliveryWay="
				+ deliveryWay + ", deliveryNumber=" + deliveryNumber + ", deliveryAddress=" + deliveryAddress
				+ ", deliveryDetailAddress=" + deliveryDetailAddress + ", deliveryTel=" + deliveryTel + ", staffCode="
				+ staffCode + ", goodsCode=" + Arrays.toString(goodsCode) + ", setCode=" + Arrays.toString(setCode)
				+ ", rentalCount=" + Arrays.toString(rentalCount) + ", contractTotalPrice=" + contractTotalPrice
				+ ", inputStaffCode=" + inputStaffCode + ", inputDate=" + inputDate + "]";
	}
	
}
