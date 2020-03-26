package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AsExchangeController {
	
	
	@PostMapping("/eInsert")
	public String eInsert(){
		
		return "/asExchange/eList";
			
	}
	
	
	
	@GetMapping("/eList")
	public String aInsert(){
		
		
		return "/asExchange/eList";
		
		
	}
	
	
	@GetMapping("/eUpdate")
	public String eUpdate(){
		
		
		return "/asExchange/eUpdate";
		
		
	}

}
