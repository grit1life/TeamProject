package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.service.GoodsCategoryService;
import kr.or.ksmart.domain.Goods;

@RestController
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@PostMapping(value = "/goodsCategory")
	public int insertGoodsCategory (Goods goods){
		return goodsCategoryService.insertGoodsCategory(goods);
	}
	
	@GetMapping(value = "/goodsCategory")
	public List<Goods> getGoodsCategoryList (){
		return goodsCategoryService.getGoodsCategoryList();
	}
	
	@GetMapping(value = "/goodsCategory/{goodsCategoryCode}")
	public Goods getGoodsCategory (@PathVariable("goodsCategoryCode") final String goodsCategoryCode) {
		return goodsCategoryService.getGoodsCategory(goodsCategoryCode);
	}
	
	@PutMapping(value = "/goodsCategory")
	public int updateGoodsCategory (Goods goods) {
		return goodsCategoryService.updateGoodsCategory(goods);
	}
	
	@DeleteMapping(value = "/goodsCategory/{goodsCategoryCode}")
	public int updateGoodsCategory (@PathVariable("goodsCategoryCode") final String goodsCategoryCode) {
		return goodsCategoryService.deleteGoodsCategory(goodsCategoryCode);
	}
	
}
