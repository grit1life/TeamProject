package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.BoardFile;
import kr.or.ksmart.service.BoardService;


@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String entrance() {
		return "entranceSon";
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
