package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.service.PriceService;

@Controller
public class PriceController {

	@Autowired
	private PriceService priceService;
	
	@PostMapping(value="/saleApplication", produces = "application/json")
	@ResponseBody
	public double saleApplication(@RequestParam(value="period")String period) {
		double rate = priceService.saleApplication(period);
		System.out.println("saleApplication");
		return rate;
	}
	
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
