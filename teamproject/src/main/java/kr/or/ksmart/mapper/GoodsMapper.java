package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Goods;

@Mapper
public interface GoodsMapper {
	
	public int insertGoods(Goods goods);
	
	public List<Goods> getGoodsList();
	
	public Goods getGoods(String goodsCode);
	
	public int updateGoods(Goods goods);
	
	public int deleteGoods(String goodsCode);

}
