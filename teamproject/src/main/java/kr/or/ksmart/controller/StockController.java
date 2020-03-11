package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	
	@GetMapping("/changeList")
	public String stockEdit () {
		return "stockChange/changeList";
	}
	
	@GetMapping("/stockList")
	public String stockList () {
		return "stock/stockList";
	}

}
