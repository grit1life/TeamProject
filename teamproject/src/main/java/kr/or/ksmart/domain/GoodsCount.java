package kr.or.ksmart.domain;

public class GoodsCount {
	
	private String goodsCode;
	private String goodsCategoryCode;
	private String goodsName;
	private String goodsBarcode;
	private int stockCount;
	private String goodsInputDate;
	private String goodsDesc;
	
	private String rentalDayPrice;
	private String priceInputDdate;
	private int priceInputStaffCode;
	
	private String goodsCategoryName;//ok
	
	private String setCode;
	private String setName;
	private String setDayPrice;
	private String setInputDate;
	private int setInputStaffCode;
	
	private String setSerch;
	
	private String rentalPransCount;
	private String rentingCount;
	private int rentalCanCount;
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsCategoryCode() {
		return goodsCategoryCode;
	}
	public void setGoodsCategoryCode(String goodsCategoryCode) {
		this.goodsCategoryCode = goodsCategoryCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsBarcode() {
		return goodsBarcode;
	}
	public void setGoodsBarcode(String goodsBarcode) {
		this.goodsBarcode = goodsBarcode;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public String getGoodsInputDate() {
		return goodsInputDate;
	}
	public void setGoodsInputDate(String goodsInputDate) {
		this.goodsInputDate = goodsInputDate;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public String getRentalDayPrice() {
		return rentalDayPrice;
	}
	public void setRentalDayPrice(String rentalDayPrice) {
		this.rentalDayPrice = rentalDayPrice;
	}
	public String getPriceInputDdate() {
		return priceInputDdate;
	}
	public void setPriceInputDdate(String priceInputDdate) {
		this.priceInputDdate = priceInputDdate;
	}
	public int getPriceInputStaffCode() {
		return priceInputStaffCode;
	}
	public void setPriceInputStaffCode(int priceInputStaffCode) {
		this.priceInputStaffCode = priceInputStaffCode;
	}
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
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
	public String getSetInputDate() {
		return setInputDate;
	}
	public void setSetInputDate(String setInputDate) {
		this.setInputDate = setInputDate;
	}
	public int getSetInputStaffCode() {
		return setInputStaffCode;
	}
	public void setSetInputStaffCode(int setInputStaffCode) {
		this.setInputStaffCode = setInputStaffCode;
	}
	public String getSetSerch() {
		return setSerch;
	}
	public void setSetSerch(String setSerch) {
		this.setSerch = setSerch;
	}
	public String getRentalPransCount() {
		return rentalPransCount;
	}
	public void setRentalPransCount(String rentalPransCount) {
		this.rentalPransCount = rentalPransCount;
	}
	public String getRentingCount() {
		return rentingCount;
	}
	public void setRentingCount(String rentingCount) {
		this.rentingCount = rentingCount;
	}
	public int getRentalCanCount() {
		return rentalCanCount;
	}
	public void setRentalCanCount(int rentalCanCount) {
		this.rentalCanCount = rentalCanCount;
	}
	@Override
	public String toString() {
		return "GoodsCount [goodsCode=" + goodsCode + ", goodsCategoryCode=" + goodsCategoryCode + ", goodsName="
				+ goodsName + ", goodsBarcode=" + goodsBarcode + ", stockCount=" + stockCount + ", goodsInputDate="
				+ goodsInputDate + ", goodsDesc=" + goodsDesc + ", rentalDayPrice=" + rentalDayPrice
				+ ", priceInputDdate=" + priceInputDdate + ", priceInputStaffCode=" + priceInputStaffCode
				+ ", goodsCategoryName=" + goodsCategoryName + ", setCode=" + setCode + ", setName=" + setName
				+ ", setDayPrice=" + setDayPrice + ", setInputDate=" + setInputDate + ", setInputStaffCode="
				+ setInputStaffCode + ", setSerch=" + setSerch + ", rentalPransCount=" + rentalPransCount
				+ ", rentingCount=" + rentingCount + ", rentalCanCount=" + rentalCanCount + "]";
	}
	


}
