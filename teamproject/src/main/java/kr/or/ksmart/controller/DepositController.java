package kr.or.ksmart.controller;

import java.util.HashMap;
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

import kr.or.ksmart.domain.Deposit;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.service.DepositService;
import kr.or.ksmart.service.ShipmentService;

@Controller
public class DepositController {
	
	@Autowired
	private DepositService depositService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	/**
	 *   입금 정보
	 * @param model
	 * @return
	 */
	@GetMapping("/staff/depositList")
	public String depositList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			,@RequestParam(value="paidPage", required = false, defaultValue = "1") int paidPage) {
		Pagination<List<Deposit>> pagination = depositService.getDepositList(page);
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		
		Pagination<List<Deposit>> paidPagination = depositService.getPaidDepositList(paidPage);
		model.addAttribute("paidList", paidPagination.getList());
		model.addAttribute("paidCurrentPage", paidPagination.getCurrentPage());
		model.addAttribute("paidStartPage", paidPagination.getStartPage());
		model.addAttribute("paidEndPage", paidPagination.getEndPage());
		model.addAttribute("paidLastPage", paidPagination.getLastPage());
		
		return "docBill/depositList";
	}
	

	@GetMapping("/staff/depositSearchList")
	public String depositSearchList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			,@RequestParam(value="paidPage", required = false, defaultValue = "1") int paidPage
			,Deposit deposit) {
		Pagination<List<Deposit>> pagination = depositService.getDepositSearchList(page, deposit);
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		
		Pagination<List<Deposit>> paidPagination = depositService.getPaidDepositSearchList(paidPage, deposit);
		model.addAttribute("paidList", paidPagination.getList());
		model.addAttribute("paidCurrentPage", paidPagination.getCurrentPage());
		model.addAttribute("paidStartPage", paidPagination.getStartPage());
		model.addAttribute("paidEndPage", paidPagination.getEndPage());
		model.addAttribute("paidLastPage", paidPagination.getLastPage());
		
		model.addAttribute("deposit", deposit);
		return "docBill/depositSearchList";
	}
	
	@PostMapping("/staff/updateDepositList")
	public @ResponseBody Map<String, Object> updateDepositList(@RequestBody Map<String, Object> paramMap) {
		int result = depositService.updateDepositList(paramMap);
		if("1".equals(paramMap.get("billPayNumber"))) {
			shipmentService.insertShipmentList(paramMap);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		return map;
	}
}
