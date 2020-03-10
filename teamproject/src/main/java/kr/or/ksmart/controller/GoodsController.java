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
		return "goods/list";
	}
	@GetMapping("/goodsPurchase")
	public String purchaseList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goods/purchaseList";
	}
	@GetMapping("/goodsSell")
	public String sellList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goods/sellList";
	}
	@GetMapping("/goodsDiscard")
	public String discardList(Model model) {
		model.addAttribute("goodsList", goodsService.getGoodsList());
		return "goods/discardList";
	}
}
