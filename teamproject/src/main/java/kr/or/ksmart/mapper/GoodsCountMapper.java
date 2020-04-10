package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.GoodsCount;

@Mapper
public interface GoodsCountMapper {

	public List<GoodsCount> setGoods();
	
	public List<GoodsCount> goodsCount(GoodsCount goodsCount);
	
	public List<GoodsCount> setCount(GoodsCount goodsCount);
	
	
}
