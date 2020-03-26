package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Goods;

@Mapper
public interface GoodsCategoryMapper {
	
	public int insertGoodsCategory (Goods goods);
	
	public List<Goods> getGoodsCategoryList ();
	
	public Goods getGoodsCategory (String goodsCategoryCode);
	
	public int updateGoodsCategory (Goods goods);
	
	public int deleteGoodsCategory (String goodsCategoryCode);

}
