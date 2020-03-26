package kr.or.ksmart.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	
	private String goodsCode;
	private String goodsCategoryCode;
	private String goodsName;
	private String goodsBarcode;
	private int stockCount;
	private String goodsInputDate;
	private String goodsDesc;
	
	private MultipartFile img;
	private String originImgName;
	private String convertImgName;
	
	private String goodsCategoryName;
	
	private String goodsTradeCode;
	private String goodsTradeCategory;
	private String goodsTradeCount;
	private String goodsTradeCost;
	private String goodsTradeInputDate;
	
	private String stockChangeCode;
	private String stockChangeCategory;
	private String stockCountBefore;
	private String stockCountAfter;
	private String stockChangeInputDate;
	
	private List<MultipartFile> file;
	private String fileCode;
	private String originFileName;
	private String convertFileName;

	private int goodsCountByGoodsCategory;
	private int stockCountByGoodsCategory;
	
	private int stockByDay;
	private int totalStockIncrease;
	private int totalStockDecrease;
	
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
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public String getOriginImgName() {
		return originImgName;
	}
	public void setOriginImgName(String originImgName) {
		this.originImgName = originImgName;
	}
	public String getConvertImgName() {
		return convertImgName;
	}
	public void setConvertImgName(String convertImgName) {
		this.convertImgName = convertImgName;
	}
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}
	public String getGoodsTradeCode() {
		return goodsTradeCode;
	}
	public void setGoodsTradeCode(String goodsTradeCode) {
		this.goodsTradeCode = goodsTradeCode;
	}
	public String getGoodsTradeCategory() {
		return goodsTradeCategory;
	}
	public void setGoodsTradeCategory(String goodsTradeCategory) {
		this.goodsTradeCategory = goodsTradeCategory;
	}
	public String getGoodsTradeCount() {
		return goodsTradeCount;
	}
	public void setGoodsTradeCount(String goodsTradeCount) {
		this.goodsTradeCount = goodsTradeCount;
	}
	public String getGoodsTradeCost() {
		return goodsTradeCost;
	}
	public void setGoodsTradeCost(String goodsTradeCost) {
		this.goodsTradeCost = goodsTradeCost;
	}
	public String getGoodsTradeInputDate() {
		return goodsTradeInputDate;
	}
	public void setGoodsTradeInputDate(String goodsTradeInputDate) {
		this.goodsTradeInputDate = goodsTradeInputDate;
	}
	public String getStockChangeCode() {
		return stockChangeCode;
	}
	public void setStockChangeCode(String stockChangeCode) {
		this.stockChangeCode = stockChangeCode;
	}
	public String getStockChangeCategory() {
		return stockChangeCategory;
	}
	public void setStockChangeCategory(String stockChangeCategory) {
		this.stockChangeCategory = stockChangeCategory;
	}
	public String getStockCountBefore() {
		return stockCountBefore;
	}
	public void setStockCountBefore(String stockCountBefore) {
		this.stockCountBefore = stockCountBefore;
	}
	public String getStockCountAfter() {
		return stockCountAfter;
	}
	public void setStockCountAfter(String stockCountAfter) {
		this.stockCountAfter = stockCountAfter;
	}
	public String getStockChangeInputDate() {
		return stockChangeInputDate;
	}
	public void setStockChangeInputDate(String stockChangeInputDate) {
		this.stockChangeInputDate = stockChangeInputDate;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}
	public String getFileCode() {
		return fileCode;
	}
	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getConvertFileName() {
		return convertFileName;
	}
	public void setConvertFileName(String convertFileName) {
		this.convertFileName = convertFileName;
	}
	public int getGoodsCountByGoodsCategory() {
		return goodsCountByGoodsCategory;
	}
	public void setGoodsCountByGoodsCategory(int goodsCountByGoodsCategory) {
		this.goodsCountByGoodsCategory = goodsCountByGoodsCategory;
	}
	public int getStockCountByGoodsCategory() {
		return stockCountByGoodsCategory;
	}
	public void setStockCountByGoodsCategory(int stockCountByGoodsCategory) {
		this.stockCountByGoodsCategory = stockCountByGoodsCategory;
	}
	public int getStockByDay() {
		return stockByDay;
	}
	public void setStockByDay(int stockByDay) {
		this.stockByDay = stockByDay;
	}
	public int getTotalStockIncrease() {
		return totalStockIncrease;
	}
	public void setTotalStockIncrease(int totalStockIncrease) {
		this.totalStockIncrease = totalStockIncrease;
	}
	public int getTotalStockDecrease() {
		return totalStockDecrease;
	}
	public void setTotalStockDecrease(int totalStockDecrease) {
		this.totalStockDecrease = totalStockDecrease;
	}

}