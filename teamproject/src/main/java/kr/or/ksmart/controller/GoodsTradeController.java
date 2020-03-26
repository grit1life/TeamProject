package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.Goods;

@Controller
public class GoodsTradeController {
	
	@GetMapping("/admin/goodsTradeInsert")
	public String insertGoodsTrade (Goods goods) {
		
		return "goods/history";
	}

}
