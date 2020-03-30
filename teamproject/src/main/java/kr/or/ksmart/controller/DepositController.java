package kr.or.ksmart.controller;

import java.util.HashMap;
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
	public String depositList(Model model, @RequestParam(value="page", required = false) String page
							,@RequestParam(value="paidPage", required = false) String paidPage) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = depositService.getDepositList(pageNum);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		if(paidPage==null) {
			paidPage = "1";
		}
		int paidPageNum = Integer.parseInt(paidPage);
		Map<String, Object> paidMap = depositService.getPaidDepositList(paidPageNum);
		model.addAttribute("paidList", paidMap.get("list"));
		model.addAttribute("paidCurrentPage", map.get("currentPage"));
		model.addAttribute("paidStartPage", map.get("startPage"));
		model.addAttribute("paidEndPage", map.get("endPage"));
		model.addAttribute("paidLastPage", map.get("lastPage"));
		return "docBill/depositList";
	}
	

	@GetMapping("/staff/depositSearchList")
	public String depositSearchList(Model model, @RequestParam(value="page", required = false) String page
							,@RequestParam(value="paidPage", required = false) String paidPage
							,Deposit deposit
								) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = depositService.getDepositSearchList(pageNum, deposit);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		if(paidPage==null) {
			paidPage = "1";
		}
		int paidPageNum = Integer.parseInt(paidPage);
		Map<String, Object> paidMap = depositService.getPaidDepositSearchList(paidPageNum, deposit);
		model.addAttribute("paidList", paidMap.get("list"));
		model.addAttribute("paidCurrentPage", map.get("currentPage"));
		model.addAttribute("paidStartPage", map.get("startPage"));
		model.addAttribute("paidEndPage", map.get("endPage"));
		model.addAttribute("paidLastPage", map.get("lastPage"));
		
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
