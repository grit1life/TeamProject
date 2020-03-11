package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocContractController {

	@GetMapping("/contractInsert")
	public String contractInsert() {
		
		return "docContract/contractInsert";
	}
	@GetMapping("/contractList")
	public String estimateList() {
		
		return "docContract/contractList";
	}
}
