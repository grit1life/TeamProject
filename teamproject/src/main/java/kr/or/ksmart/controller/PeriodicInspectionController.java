package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeriodicInspectionController {
	
	//리스트
	@GetMapping("/pList")
	public String pInsert() {
		
		
		return "/periodicInspection/pList";
	}

}
