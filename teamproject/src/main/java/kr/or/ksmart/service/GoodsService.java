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
	
	// 상품 전체 조회 페이지
	public List<Goods> getGoodsList() {
		return goodsMapper.getGoodsList();
	}
	
	// 상품 개별 조회 페이지
	public Goods getGoods() {
		return goodsMapper.getGoods();
	}

}
