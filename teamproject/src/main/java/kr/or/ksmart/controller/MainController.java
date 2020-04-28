package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
	@PostMapping("/logout")
	public @ResponseBody Map<String, Object> logout(@RequestParam (value = "s") String s) {
		System.out.println(s); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "aa");
		return map;
	}
}
