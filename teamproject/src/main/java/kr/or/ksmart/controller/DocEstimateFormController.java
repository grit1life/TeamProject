package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.service.DocEstimateFormService;

@Controller
public class DocEstimateFormController {
	
	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@GetMapping("customer/estimateForm")
	public String estimateForm(@RequestParam(value = "estimateCode") String estimateCode,
							   @RequestParam(value = "no") String no,
							   Model model) {
		List<DocEstimateForm> eList = docEstimateFormService.getEstimateForm(estimateCode, no);
		Mycompany mycompany = docEstimateFormService.getMycompany();
		model.addAttribute("eList", eList);
		model.addAttribute("mycompany", mycompany);
		System.out.println();
		return "docEstimate/estimateForm";
	}
	
	@GetMapping("staff/estimateFormList")
	public String estimateFormList(Model model) {
		List<DocEstimateForm> eList = docEstimateFormService.getEstimateList();
		model.addAttribute("eList", eList);
		return "docEstimate/staffEstimateFormList";
	}
	
	@GetMapping("customer/estimateFormList")
	public String estimateCustomerFormList(Model model) {
		//String cId = "client01"; //임시 고객 아이디 로그인시 연결필요
		//List<DocEstimateForm> eList = docEstimateFormService.getEstimateList(cId);
		//model.addAttribute("eList", eList);
		return "docEstimate/cusEstimateFormList";
	}
	
	@PostMapping("ajaxEstimateFormList")
	public @ResponseBody List<DocEstimateForm> getAjaxFormList(@RequestBody Map<String, Object> map) {
		List<DocEstimateForm> list = docEstimateFormService.getAjaxFormList(map);
		return list; 
	}
}
