package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import kr.or.ksmart.domain.RepairFeeBillingAndDeposit;
import kr.or.ksmart.service.RepairFeeBillingAndDepositService;

@Controller
public class AsRepairFeeBillingAndDepositController {
	
	
	@Autowired
	private RepairFeeBillingAndDepositService RepairFeeBillingAndDepositService;
	
	
	@GetMapping("/repairFeeBillingAndDeposit")
	public String repairFeeBillingAndDeposit(){
		
		return "/asRepair/repairFeeBillingAndDeposit";
		
		
		
	}
	
	@PostMapping("/rdInsert")
	public String rdInsert(RepairFeeBillingAndDeposit RepairFeeBillingAndDeposit) {
		
		RepairFeeBillingAndDepositService.rdInsert(RepairFeeBillingAndDeposit);
		
		return "/asRepair/repairFeeBillingAndDeposit";
	}
		
	
	@GetMapping("/rdList")
	public String rbList(){
		
		return "/asRepairFeeBillingAndDeposit/rdList";
		
		
		
	}
	
	@GetMapping("/rdUpdate")
	public String rdUpdate(){
		
		return "/asRepairFeeBillingAndDeposit/rdUpdate";
		
		
		
	}
	
	
	
}
