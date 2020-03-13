package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocBillController {

	@GetMapping("/staff/billList")
	public String billList() {
		return "docBill/billList";
	}
	@GetMapping("/staff/depositList")
	public String depositList() {
		return "docBill/depositList";
	}
	
}
