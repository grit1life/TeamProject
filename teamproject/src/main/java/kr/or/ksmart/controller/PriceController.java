package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PriceController {

	@GetMapping("/goodsPriceInsert")
	public String goodsPriceInsert() {
		return "price/goodsPriceInsert";
	}
	@GetMapping("/goodsPriceList")
	public String goodsPriceList() {
		return "price/goodsPriceList";
	}
	@GetMapping("/saleInsert")
	public String saleInsert() {
		return "price/saleInsert";
	}
	@GetMapping("/saleList")
	public String saleList() {
		return "price/saleList";
	}
}
