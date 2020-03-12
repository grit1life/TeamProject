package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.service.GoodsService;

@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping(value = "/goodsList", produces = "application/json")
	public List<Goods> getGoodsList() {
		return goodsService.getGoodsList();
	}
}