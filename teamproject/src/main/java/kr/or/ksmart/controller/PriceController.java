package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PriceController {

	@GetMapping("/admin/goodsPriceInsert")
	public String goodsPriceInsert() {
		return "price/goodsPriceInsert";
	}
	@GetMapping("/goodsPriceList")
	public String goodsPriceList() {
		return "price/goodsPriceList";
	}
	@GetMapping("/admin/basicSaleInsert")
	public String basicSaleInsert() {
		return "price/basicSaleInsert";
	}
	@GetMapping("/basicSaleList")
	public String basicSaleList() {
		return "price/basicSaleList";
	}
	@GetMapping("/admin/specialSaleInsert")
	public String specialSaleInsert() {
		return "price/specialSaleInsert";
	}
	@GetMapping("/specialSaleList")
	public String specialSaleList() {
		return "price/specialSaleList";
	}
}
