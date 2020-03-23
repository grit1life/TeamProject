package kr.or.ksmart.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	
	private String goodsCode;
	private String goodsCategoryCode;
	private String goodsName;
	private String goodsBarcode;
	private String goodsInputStaffCode;
	private String goodsInputDate;
	private String goodsDesc;
	
	private String goodsCategoryName;
	private String goodsCategoryInputStaffCode;
	private String goodsCategoryInputDate;
	
	private List<MultipartFile> file;
	private String originFileName;
	private String convertFileName;
	
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
	public String getGoodsInputStaffCode() {
		return goodsInputStaffCode;
	}
	public void setGoodsInputStaffCode(String goodsInputStaffCode) {
		this.goodsInputStaffCode = goodsInputStaffCode;
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
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	public void setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName = goodsCategoryName;
	}
	public String getGoodsCategoryInputStaffCode() {
		return goodsCategoryInputStaffCode;
	}
	public void setGoodsCategoryInputStaffCode(String goodsCategoryInputStaffCode) {
		this.goodsCategoryInputStaffCode = goodsCategoryInputStaffCode;
	}
	public String getGoodsCategoryInputDate() {
		return goodsCategoryInputDate;
	}
	public void setGoodsCategoryInputDate(String goodsCategoryInputDate) {
		this.goodsCategoryInputDate = goodsCategoryInputDate;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		this.file = file;
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
	
}