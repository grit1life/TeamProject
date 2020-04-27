package kr.or.ksmart.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;
@Data
public class DocContractInsert {

	/* 계약서 */
	private String contractCode;
	private String contractNo;
	
	private String customerId;
	private String gradeName;
	
	private String rentalFromDate;
	private String rentalToDate;
	private String rentalPeriod;
	private String contractTotalPrice;
	private String contractNote;
	
	private String deliveryWay;
	private String deliveryNumber;
	private String deliveryAddress;
	private String deliveryDetailAddress;
	private String deliveryTel;
	
	private String staffCode;
	
	private String[] goodsCode;
	private String[] setCode;
	private String[] rentalCount;/* 주문갯수 */
	private List<Map<String,Object>> goodsArray;
		
	private String inputStaffCode;
	private String inputDate;
	
	public List<Map<String,Object>> getGoodsArray(){
		if(goodsCode != null) {
			System.out.println("------------array---------------");
			this.goodsArray = new ArrayList<Map<String,Object>>();
			for(int i=0; i < goodsCode.length; i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("goodsCode", goodsCode[i]);
				map.put("setCode", setCode[i]);
				map.put("rentalCount", rentalCount[i]);
				map.put("index", i+1);
				this.goodsArray.add(map);
			}
		}
		return goodsArray;
	}
	
	
}
