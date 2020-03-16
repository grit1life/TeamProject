package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	//	상품 Create
	public String insertGoods(Goods goods) {
		int insertResult = goodsMapper.insertGoods(goods);
		String resultMsg;
		
		if(insertResult > 0) {
			resultMsg = "insert successed";
		} else {
			resultMsg = "insert failed";
		}
		
		return resultMsg;
	}
	
	//	상품 전체 Read
	public List<Goods> getGoodsList(){
		return goodsMapper.getGoodsList();
	}
	
	// 상품 개별 Read
	public Goods getGoods(String goodsCode) {
		return goodsMapper.getGoods(goodsCode);
	}
	
	// 상품 Update
	public String updateGoods (Goods goods) {
		int insertResult = goodsMapper.insertGoods(goods);
		String resultMsg;
		
		if(insertResult > 0) {
			resultMsg = "update successed";
		} else {
			resultMsg = "update failed";
		}
		
		return resultMsg;
	}
	
	// 상품 Delete
	public String deleteGoods (String goodsCode) {
		int insertResult = goodsMapper.deleteGoods(goodsCode);
		String resultMsg;
		
		if(insertResult > 0) {
			resultMsg = "delete successed";
		} else {
			resultMsg = "delete failed";
		}
		
		return resultMsg;
	}

}
