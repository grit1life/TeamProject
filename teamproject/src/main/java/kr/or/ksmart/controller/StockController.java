package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	
	@GetMapping("/stock/edit")
	public String stockEdit () {
		return "stock/edit";
	}
	
	@GetMapping("/stock/list")
	public String stockList () {
		return "stock/list";
	}

}
