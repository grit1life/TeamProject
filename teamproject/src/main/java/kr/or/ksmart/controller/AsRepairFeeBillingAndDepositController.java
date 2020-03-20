package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsRepairFeeBillingAndDepositController {
	
	@GetMapping("/rdList")
	public String rbList(){
		
		return "/asRepairFeeBillingAndDeposit/rdList";
		
		
		
	}
	
	@GetMapping("/rdUpdate")
	public String rdUpdate(){
		
		return "/asRepairFeeBillingAndDeposit/rdUpdate";
		
		
		
	}
	
	
	
}
