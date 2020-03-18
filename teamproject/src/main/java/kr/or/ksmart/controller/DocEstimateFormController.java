package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocEstimateFormController {
	
	@GetMapping("customer/estimateForm")
	public String estimateForm() {
		
		return "docEstimate/estimateForm";
	}
}
