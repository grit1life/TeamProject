package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsController {
	
	@GetMapping("/aInsert")
	public String aInsert(){
		
		
		return "/as/aInsert";
		
		
	}
	
	@GetMapping("/aList")
	public String aList(){
		
		
		return "/as/aList";
		
		
	}
	
	

}
