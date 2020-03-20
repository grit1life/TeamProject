package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.service.GoodsCategoryService;
import kr.or.ksmart.domain.Goods;

@RestController
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@GetMapping(value = "/goodsCategory")
	public List<Goods> getGoodsCategoryList (){
		return goodsCategoryService.getGoodsCategoryList();
	}
	
}
