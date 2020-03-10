package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {
	
	@GetMapping("/goodsManage")
	public String goodsList () {
		return "goods/goodsManage";
	}

}
