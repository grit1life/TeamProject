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
							   Model model) {
		Map<String, Object> map = docEstimateFormService.getEstimateForm(estimateCode);
		Mycompany mycompany = docEstimateFormService.getMycompany();
		model.addAttribute("eList", map.get("resultList"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("remainClmn", map.get("remainClmn"));
		model.addAttribute("cnt", map.get("cnt"));
		model.addAttribute("mycompany", mycompany);
		return "docEstimate/estimateForm";
	}
	
	@GetMapping("staff/estimateFormList")
	public String estimateFormList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = docEstimateFormService.getEstimateList(pageNum);
		model.addAttribute("eList", map.get("eList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "docEstimate/staffEstimateFormList";
	}
	
	@GetMapping("customer/estimateFormList")
	public String estimateCustomerFormList(Model model) {
		//String cId = "client01"; //임시 고객 아이디 로그인시 연결필요
		//List<DocEstimateForm> eList = docEstimateFormService.getCusEstimateList(cId);
		//model.addAttribute("eList", eList);
		return "docEstimate/cusEstimateFormList";
	}
	
	/*
	@PostMapping("/ajaxEstimateFormList")
	public @ResponseBody List<DocEstimateForm> getAjaxFormList(@RequestBody Map<String, Object> map) {
		List<DocEstimateForm> list = docEstimateFormService.getAjaxFormList(map);
		return list; 
	}
	*/
}
