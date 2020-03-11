package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/goodsList")
	public String goodsList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goods/goodsList";
	}
	
	@GetMapping("/purchaseList")
	public String purchaseList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goodsPurchase/purchaseList";
	}
	
	@GetMapping("/sellList")
	public String sellList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goodsSell/sellList";
	}
	
	@GetMapping("/discardList")
	public String discardList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goodsDiscard/discardList";
	}
}
