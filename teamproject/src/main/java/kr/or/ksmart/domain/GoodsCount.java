package kr.or.ksmart.domain;

public class GoodsCount {
	
	private String goodsCode;
	private String goodsCategoryCode;
	private String goodsName;
	private String goodsBarcode;
	private int stockCount;
	private String goodsInputDate;
	private String goodsDesc;
	
	private String rental_day_price;
	private String price_input_date;
	private int price_input_staff_code;
	
	private String goodsCategoryName;
	
	private String setCode;
	private String setName;
	private String setDayPrice;
	private String setInputDate;
	private int setInputStaffCode;
	
	private String rentalPransCount;
	private String rentingCount;
	private int rentalCanCount;
	
	@Override
	public String toString() {
		return "GoodsCount [goodsCode=" + goodsCode + ", goodsCategoryCode=" + goodsCategoryCode + ", goodsName="
				+ goodsName + ", goodsBarcode=" + goodsBarcode + ", stockCount=" + stockCount + ", goodsInputDate="
				+ goodsInputDate + ", goodsDesc=" + goodsDesc + ", rental_day_price=" + rental_day_price
				+ ", price_input_date=" + price_input_date + ", price_input_staff_code=" + price_input_staff_code
				+ ", goodsCategoryName=" + goodsCategoryName + ", setCode=" + setCode + ", setName=" + setName
				+ ", setDayPrice=" + setDayPrice + ", setInputDate=" + setInputDate + ", setInputStaffCode="
				+ setInputStaffCode + ", rentalPransCount=" + rentalPransCount + ", rentingCount=" + rentingCount
				+ ", rentalCanCount=" + rentalCanCount + "]";
	}
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
	public String getRental_day_price() {
		return rental_day_price;
	}
	public void setRental_day_price(String rental_day_price) {
		this.rental_day_price = rental_day_price;
	}
	public String getPrice_input_date() {
		return price_input_date;
	}
	public void setPrice_input_date(String price_input_date) {
		this.price_input_date = price_input_date;
	}
	public int getPrice_input_staff_code() {
		return price_input_staff_code;
	}
	public void setPrice_input_staff_code(int price_input_staff_code) {
		this.price_input_staff_code = price_input_staff_code;
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




	
	
}
