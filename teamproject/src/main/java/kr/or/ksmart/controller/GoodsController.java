package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.service.GoodsService;
import kr.or.ksmart.domain.Goods;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@PostMapping(value = "/goods")
	public String insertgoods (Goods goods){
		return goodsService.insertGoods(goods);
	}
	
	@GetMapping(value = "/goods")
	public List<Goods> getgoodsList (){
		return goodsService.getGoodsList();
	}
	
	@GetMapping(value = "/goods/{goodsCode}")
	public Goods getgoods (@PathVariable("goodsCode") final String goodsCode) {
		return goodsService.getGoods(goodsCode);
	}
	
	@PutMapping(value = "/goods")
	public String updategoods (Goods goods) {
		return goodsService.updateGoods(goods);
	}
	
	@DeleteMapping(value = "/goods/{goodsCode}")
	public int updategoods (@PathVariable("goodsCode") final String goodsCode) {
		return goodsService.deleteGoods(goodsCode);
	}

}
