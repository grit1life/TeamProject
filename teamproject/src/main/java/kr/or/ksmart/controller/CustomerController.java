package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	
	
	//고객,거래처 등록
	@GetMapping("/cinsert")
	public String addCustomer() {
		
		
		return "/customer/cinsert";
	}

}
