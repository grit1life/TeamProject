package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.GoodsCount;
import kr.or.ksmart.mapper.GoodsCountMapper;

@Service
@Transactional
public class GoodsCountService {
	@Autowired
	private GoodsCountMapper goodsCountMapper;
	
	public List<GoodsCount> setGoods(){
		List<GoodsCount> sgList = goodsCountMapper.setGoods();
		return sgList;
	}
	
	public List<GoodsCount> goodscount(GoodsCount goodsCount){
		List<GoodsCount> gcList = goodsCountMapper.goodsCount(goodsCount);
		return gcList;
	}
	
	public List<GoodsCount> setCount(GoodsCount goodsCount){
		return goodsCountMapper.setCount(goodsCount);
	}
}
