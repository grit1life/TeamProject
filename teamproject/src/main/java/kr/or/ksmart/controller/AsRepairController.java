package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsRepairController {
	
	
	@GetMapping("/rList")
	public String rInsert(){
		
		
		return "/asRepair/rList";
		
		
	}
	
	@GetMapping("/rUpdate")
	public String rUpdate(){
		
		
		return "/asRepair/rUpdate";
		
		
	}

}
