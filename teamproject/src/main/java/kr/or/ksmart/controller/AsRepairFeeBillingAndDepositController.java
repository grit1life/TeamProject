package kr.or.ksmart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.RepairFeeBillingAndDeposit;
import kr.or.ksmart.service.RepairFeeBillingAndDepositService;

@Controller
public class AsRepairFeeBillingAndDepositController {
	
	
	@Autowired
	private RepairFeeBillingAndDepositService RepairFeeBillingAndDepositService;
	
	//청구서
	@GetMapping("/asRepairBillForm")
	public String asRepairBillForm(){
		
		return "/asRepairFeeBillingAndDeposit/asRepairBillForm";
		
		
		
	}
	
	
	//등록
	@GetMapping("/repairFeeBillingAndDeposit")
	public String repairFeeBillingAndDeposit(){
		
		return "/asRepair/repairFeeBillingAndDeposit";
		
		
		
	}
	
	@PostMapping("/rdInsert")
	public String rdInsert(RepairFeeBillingAndDeposit RepairFeeBillingAndDeposit) {
		
		RepairFeeBillingAndDepositService.rdInsert(RepairFeeBillingAndDeposit);
		
		return "/asRepair/repairFeeBillingAndDeposit";
	}
	
	
	
	//리스트
	@GetMapping("/rdList")
	public String pList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = RepairFeeBillingAndDepositService.getrepairFeeBillingAndDepositList(pageNum);
		
		model.addAttribute("RepairFeeBillingAndDepositList", map.get("RepairFeeBillingAndDepositList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "/asRepairFeeBillingAndDeposit/rdList";
	}
		
	
	
	@GetMapping("/rdUpdate")
	public String rdUpdate(){
		
		return "/asRepairFeeBillingAndDeposit/rdUpdate";
		
		
		
	}
	
	
	
}
