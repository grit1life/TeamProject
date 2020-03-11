package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocEstimateController {
	
	@GetMapping("/estimateInsert")
	public String estimateInsert() {
		
		return "docEstimate/estimateInsert";
	}
	@GetMapping("/estimateList")
	public String estimateList() {
		
		return "docEstimate/estimateList";
	}
}
