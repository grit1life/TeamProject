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

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.Return;
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
	public String returnList(Model model, @RequestParam(value="page", required = false) String page
								, @RequestParam(value="deliveredPage", required = false) String deliveredPage){
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		
		Map<String, Object> map = returnService.getReturnList(pageNum);
		model.addAttribute("staffList", docEstimateFormService.getStaffNameList());
		model.addAttribute("setList", docEstimateFormService.getSetNameList());
		model.addAttribute("goodsList", docEstimateFormService.getGoodsNameList());
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		if(deliveredPage==null) {
			deliveredPage = "1";
		}
		int deliveredPageNum = Integer.parseInt(deliveredPage);
		Map<String, Object> returnedMap = returnService.getReturnCompleteList(deliveredPageNum);
		model.addAttribute("deliveredList", returnedMap.get("list"));
		model.addAttribute("deliveredCurrentPage", returnedMap.get("currentPage"));
		model.addAttribute("deliveredStartPage", returnedMap.get("startPage"));
		model.addAttribute("deliveredEndPage", returnedMap.get("endPage"));
		model.addAttribute("lastPage", returnedMap.get("lastPage"));
		return "return/returnList";
	}
	
	@PostMapping("/ajaxReturnList")
	public @ResponseBody List<Return> ajaxReturnList(@RequestBody Map<String, Object> map){
		return returnService.ajaxReturnList((String)map.get("contractCode"));
	}
	
}
