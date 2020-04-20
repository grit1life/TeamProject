package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.DocEstimateForm;
import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.PriceSet;
import kr.or.ksmart.domain.Staff;
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
	public String estimateFormList(Model model, @RequestParam(value="page", required = false, defaultValue = "1") int page) {
		
		Pagination<List<DocEstimateForm>> p = docEstimateFormService.getEstimateList(page);
		List<Staff> staffList = docEstimateFormService.getStaffNameList();
		List<PriceSet> setList = docEstimateFormService.getSetNameList();
		List<Goods> goodsList = docEstimateFormService.getGoodsNameList();
		model.addAttribute("eList", p.getList());
		model.addAttribute("currentPage", p.getCurrentPage());
		model.addAttribute("startPage", p.getStartPage());
		model.addAttribute("endPage", p.getEndPage());
		model.addAttribute("lastPage", p.getLastPage());
		model.addAttribute("staffList", staffList);
		model.addAttribute("setList", setList);
		model.addAttribute("goodsList", goodsList);
		
		return "docEstimate/staffEstimateFormList";
	}
	
	@GetMapping("staff/estimateFormSearchList")
	public String estimateFormSearchList(Model model, @RequestParam(value="page", required = false, defaultValue = "1") int page
			   								,DocEstimateForm docEstimateForm) {
		
		  Pagination<List<DocEstimateForm>> p = docEstimateFormService.getEstimateSearchList(page, docEstimateForm);
		  List<Staff> staffList = docEstimateFormService.getStaffNameList();
		  List<PriceSet> setList = docEstimateFormService.getSetNameList();
		  List<Goods> goodsList = docEstimateFormService.getGoodsNameList();
		  model.addAttribute("eList", p.getList());
		  model.addAttribute("currentPage", p.getCurrentPage());
		  model.addAttribute("startPage", p.getStartPage());
		  model.addAttribute("endPage", p.getEndPage());
		  model.addAttribute("lastPage", p.getLastPage());
		  model.addAttribute("staffList", staffList); 
		  model.addAttribute("setList", setList);
		  model.addAttribute("goodsList", goodsList);
		 model.addAttribute("de", docEstimateForm);
		
		return "docEstimate/staffEstimateFormSearchList";
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
