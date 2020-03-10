package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Goods;

@Mapper
public interface GoodsMapper {
	
	public List<Goods> getGoodsList();
	
	public Goods getGoods();

}
