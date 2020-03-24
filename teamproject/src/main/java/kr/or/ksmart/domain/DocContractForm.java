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
	private String deriveryNumber;
	private String deriveryAddress;
	private String deriveryDetailAddress;
	private String deriveryTel;
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
	public String getDeriveryNumber() {
		return deriveryNumber;
	}
	public void setDeriveryNumber(String deriveryNumber) {
		this.deriveryNumber = deriveryNumber;
	}
	public String getDeriveryAddress() {
		return deriveryAddress;
	}
	public void setDeriveryAddress(String deriveryAddress) {
		this.deriveryAddress = deriveryAddress;
	}
	public String getDeriveryDetailAddress() {
		return deriveryDetailAddress;
	}
	public void setDeriveryDetailAddress(String deriveryDetailAddress) {
		this.deriveryDetailAddress = deriveryDetailAddress;
	}
	public String getDeriveryTel() {
		return deriveryTel;
	}
	public void setDeriveryTel(String deriveryTel) {
		this.deriveryTel = deriveryTel;
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
	private String contractDate;
	private String staffCode;
	private String inputStaffCode;
	private String inputDate;
	private String contractIsend;
	private String progressStatus;
	private String ispay;
	
}
