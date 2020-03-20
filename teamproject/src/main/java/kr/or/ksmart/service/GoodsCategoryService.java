package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.mapper.GoodsCategoryMapper;
import kr.or.ksmart.domain.Goods;

@Service
@Transactional
public class GoodsCategoryService {
	
	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;
	
	public List<Goods> getGoodsCategoryList(){
		return goodsCategoryMapper.getGoodsCategoryList();
	}
	
	public Goods getGoodsCategory (String goodsCategoryCode) {
		return goodsCategoryMapper.getGoodsCategory(goodsCategoryCode);
	}

}
