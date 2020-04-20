package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.Return;
import kr.or.ksmart.domain.ReturnSearchForm;
import kr.or.ksmart.service.DocEstimateFormService;
import kr.or.ksmart.service.ReturnService;

@Controller
public class ReturnController {

	@Autowired
	private ReturnService returnService;
	
	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@GetMapping("/staff/returnList")
	public String returnList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			, @RequestParam(value="deliveredPage", required = false, defaultValue = "1") int returnedPage){
		
		Pagination<List<Return>> pagination = returnService.getReturnList(page);
		model.addAttribute("staffList", docEstimateFormService.getStaffNameList());
		model.addAttribute("setList", docEstimateFormService.getSetNameList());
		model.addAttribute("goodsList", docEstimateFormService.getGoodsNameList());
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		
		Pagination<List<Return>> rePagination = returnService.getReturnCompleteList(returnedPage);
		model.addAttribute("deliveredList", rePagination.getList());
		model.addAttribute("deliveredCurrentPage", rePagination.getCurrentPage());
		model.addAttribute("deliveredStartPage", rePagination.getStartPage());
		model.addAttribute("deliveredEndPage", rePagination.getEndPage());
		model.addAttribute("deliveredLastPage", rePagination.getLastPage());
		return "return/returnList";
	}
	@GetMapping("/staff/returnSearchList")
	public String returnSearchList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			, @RequestParam(value="deliveredPage", required = false, defaultValue = "1") int returnedPage
			, ReturnSearchForm rsf){
		
		Pagination<List<Return>> pagination = returnService.getReturnSearchList(page, rsf);
		model.addAttribute("staffList", docEstimateFormService.getStaffNameList());
		model.addAttribute("setList", docEstimateFormService.getSetNameList());
		model.addAttribute("goodsList", docEstimateFormService.getGoodsNameList());
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		
		Pagination<List<Return>> rePagination = returnService.getReturnCompleteSearchList(returnedPage, rsf);
		model.addAttribute("deliveredList", rePagination.getList());
		model.addAttribute("deliveredCurrentPage", rePagination.getCurrentPage());
		model.addAttribute("deliveredStartPage", rePagination.getStartPage());
		model.addAttribute("deliveredEndPage", rePagination.getEndPage());
		model.addAttribute("deliveredLastPage", rePagination.getLastPage());
		return "return/returnList";
	}
	
	@PostMapping("/ajaxReturnList")
	public @ResponseBody List<Return> ajaxReturnList(@RequestParam(value="contractCode") String contractCode){
		return returnService.ajaxReturnList(contractCode);
	}
	
	@PostMapping("/returnedUpdate")
	public @ResponseBody int updateReturned(@RequestParam(value = "rContractCode") String rContractCode) {
		return returnService.updateReturned(rContractCode);
	}
	
}
