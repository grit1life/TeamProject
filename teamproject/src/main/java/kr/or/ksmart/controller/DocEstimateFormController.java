package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.service.DocEstimateFormService;

@Controller
public class DocEstimateFormController {
	
	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@GetMapping("customer/estimateForm")
	public String estimateForm() {
		
		return "docEstimate/estimateList";
	}
	
	@GetMapping("staff/estimateFormList")
	public String estimateFormList(Model model) {
		List<DocEstimateForm> eList = docEstimateFormService.getEstimateList();
		model.addAttribute("eList", eList);
		return "docEstimate/estimateList";
	}
	
	@GetMapping("customer/estimateFormList")
	public String estimateCustomerFormList(Model model) {
		String cId = "client01"; //임시 고객 아이디 로그인시 연결필요
		List<DocEstimateForm> eList = docEstimateFormService.getEstimateList(cId);
		model.addAttribute("eList", eList);
		return "docEstimate/cusEstimateList";
	}
}
