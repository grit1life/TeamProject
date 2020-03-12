package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("goods")
	public String index() {
		return "goods/goods";
	}
}
