package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.service.DocContractFormService;
import kr.or.ksmart.service.DocEstimateFormService;
import kr.or.ksmart.service.ReturnService;

@Controller
public class ReturnController {

	@Autowired
	private ReturnService returnService;
	
	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@GetMapping("/staff/returnList")
	public String returnList(Model model){
		System.out.println(returnService.getReturnList());
		model.addAttribute("staffList", docEstimateFormService.getStaffNameList());
		model.addAttribute("setList", docEstimateFormService.getSetNameList());
		model.addAttribute("goodsList", docEstimateFormService.getGoodsNameList());
		model.addAttribute("list", returnService.getReturnList());
		return "return/returnList";
	}
}
