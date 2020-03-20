package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsExchangeController {
	
	
	@GetMapping("/eList")
	public String aInsert(){
		
		
		return "/asExchange/eList";
		
		
	}
	
	
	@GetMapping("/eUpdate")
	public String eUpdate(){
		
		
		return "/asExchange/eUpdate";
		
		
	}

}
