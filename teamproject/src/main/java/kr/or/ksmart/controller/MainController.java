package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String entrance() {
		return "entrance";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/admin/goods")
	public String goods() {
		return "goods/goods";
	}
	
	@GetMapping("/admin/trade")
	public String trade() {
		return "goods/trade";
	}
	
	@GetMapping("/admin/history")
	public String history() {
		return "goods/history";
	}
	
	@GetMapping("/admin/dashboard")
	public String dashboard() {
		return "goods/dashboard";
	}
}
