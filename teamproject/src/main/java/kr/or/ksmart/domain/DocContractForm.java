package kr.or.ksmart.domain;

public class DocContractForm {

	/* 계약서 */
	private String contractCode;
	private String contractNo;
	private String customerId;
	
	private String goodsCode;
	private String setCode;
	private String rentalCount;/* 주문갯수 */
	private String rentalFromDate;
	private String rentalToDate;
	private String rentalPeriod;
	private String saleCode;
	
	private String gradeName;
	private String effectivenessDate;/* 유효기간 */
	
	private String contractTotalPrice;
	private String deliveryWay;
	private String deliveryNumber;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String deliveryTel;

	private String customerName;

	private String contractDate;
	private String staffCode;
	private String inputStaffCode;
	private String inputDate;
	private String contractIsend;
	private String progressStatus;
	private String ispay;
	private String setGoodsName;
	private String setGoodsCount;
	private String customerCompanyName;
	private String customerCompanyPresident;
	private String customerCompanyCall;
	private String goodsName;
	private String setName;
	private int count;
	private int total;
	
	public String getCustomerCompanyCall() {
		return customerCompanyCall;
	}
	public void setCustomerCompanyCall(String customerCompanyCall) {
		this.customerCompanyCall = customerCompanyCall;
	}
	public String getCustomerCompanyPresident() {
		return customerCompanyPresident;
	}
	public void setCustomerCompanyPresident(String customerCompanyPresident) {
		this.customerCompanyPresident = customerCompanyPresident;
	}
	public String getSetGoodsCount() {
		return setGoodsCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setSetGoodsCount(String setGoodsCount) {
		this.setGoodsCount = setGoodsCount;
	}
	public String getSetGoodsName() {
		return setGoodsName;
	}
	public void setSetGoodsName(String setGoodsName) {
		this.setGoodsName = setGoodsName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getSetCode() {
		return setCode;
	}
	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}
	public String getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(String rentalCount) {
		this.rentalCount = rentalCount;
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
	public String getSaleCode() {
		return saleCode;
	}
	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getEffectivenessDate() {
		return effectivenessDate;
	}
	public void setEffectivenessDate(String effectivenessDate) {
		this.effectivenessDate = effectivenessDate;
	}
	public String getContractTotalPrice() {
		return contractTotalPrice;
	}
	public void setContractTotalPrice(String contractTotalPrice) {
		this.contractTotalPrice = contractTotalPrice;
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
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
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
	public String getContractIsend() {
		return contractIsend;
	}
	public void setContractIsend(String contractIsend) {
		this.contractIsend = contractIsend;
	}
	public String getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}
	public String getIspay() {
		return ispay;
	}
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
}
