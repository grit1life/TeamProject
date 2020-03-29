package kr.or.ksmart.domain;

public class DocEstimate {

	/* 견적서 */
	private String estimateCode;
	private String estimateNo;
	private String customerId;
	
	private String goodsCode;
	private String setCode;
	private String setNo;
	private String tradingCount;/* 주문갯수 */
	private String rentalFromDate;
	private String rentalToDate;
	private String rentalPeriod;
	private String saleCode;
	
	private String tradingTotal;
	private String estimatesExpirationDate;/* 유효기간 */
	
	private String inputStaffCode;
	private String inputDate;
	private String estimatesIsend;/*종결여부*/
	
	private String estimatesNote;/*비고*/
	private String gradeName;/*등급명*/
	private int firstClmn;
	private int lastClmn;
	public int getFirstClmn() {
		return firstClmn;
	}
	public void setFirstClmn(int firstClmn) {
		this.firstClmn = firstClmn;
	}
	public int getLastClmn() {
		return lastClmn;
	}
	public void setLastClmn(int lastClmn) {
		this.lastClmn = lastClmn;
	}
	public String getEstimateCode() {
		return estimateCode;
	}
	public void setEstimateCode(String estimateCode) {
		this.estimateCode = estimateCode;
	}
	public String getEstimateNo() {
		return estimateNo;
	}
	public void setEstimateNo(String estimateNo) {
		this.estimateNo = estimateNo;
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
	public String getSetNo() {
		return setNo;
	}
	public void setSetNo(String setNo) {
		this.setNo = setNo;
	}
	public String getTradingCount() {
		return tradingCount;
	}
	public void setTradingCount(String tradingCount) {
		this.tradingCount = tradingCount;
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
	public String getTradingTotal() {
		return tradingTotal;
	}
	public void setTradingTotal(String tradingTotal) {
		this.tradingTotal = tradingTotal;
	}
	public String getEstimatesExpirationDate() {
		return estimatesExpirationDate;
	}
	public void setEstimatesExpirationDate(String estimatesExpirationDate) {
		this.estimatesExpirationDate = estimatesExpirationDate;
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
	public String getEstimatesIsend() {
		return estimatesIsend;
	}
	public void setEstimatesIsend(String estimatesIsend) {
		this.estimatesIsend = estimatesIsend;
	}
	public String getEstimatesNote() {
		return estimatesNote;
	}
	public void setEstimatesNote(String estimatesNote) {
		this.estimatesNote = estimatesNote;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	@Override
	public String toString() {
		return "DocEstimate [estimateCode=" + estimateCode + ", estimateNo=" + estimateNo + ", customerId=" + customerId
				+ ", goodsCode=" + goodsCode + ", setCode=" + setCode + ", setNo=" + setNo + ", tradingCount="
				+ tradingCount + ", rentalFromDate=" + rentalFromDate + ", rentalToDate=" + rentalToDate
				+ ", rentalPeriod=" + rentalPeriod + ", saleCode=" + saleCode + ", tradingTotal=" + tradingTotal
				+ ", estimatesExpirationDate=" + estimatesExpirationDate
				+ ", inputStaffCode=" + inputStaffCode + ", inputDate=" + inputDate + ", estimatesIsend="
				+ estimatesIsend + ", estimatesNote=" + estimatesNote + ", gradeName=" + gradeName + "]";
	}

}
