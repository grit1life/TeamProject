package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.MyCompanyDeposit;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.service.DocContractFormService;
import kr.or.ksmart.service.DocEstimateFormService;
import kr.or.ksmart.service.MyCompanyDepositService;

@Controller
public class DocContractFormController {

	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@Autowired
	private DocContractFormService docContractFormService;
	
	@Autowired
	private MyCompanyDepositService myCompanyDepositService;
	
	@GetMapping("/staff/contractFormList")
	public String staffContractFormList(Model model, @RequestParam(value="page", required = false) String page){
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = docContractFormService.getContractList(pageNum);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "docContract/staffContractFormList";
	}
	@GetMapping("/customer/contractForm")
	public String staffContractFormList(@RequestParam (value = "contractCode") String contractCode, Model model){
		List<DocContractForm> list = docContractFormService.getContractForm(contractCode);
		Mycompany mycompany = docEstimateFormService.getMycompany();
		MyCompanyDeposit deposit = myCompanyDepositService.getMyCompanyDeposit();
		model.addAttribute("list", list);
		model.addAttribute("mycompany", mycompany);
		System.out.println("+++++++++++++");
		model.addAttribute("deposit", deposit);
		return "docContract/contractForm";
	}
}
