package kr.or.ksmart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.service.DepositService;

@Controller
public class DepositController {
	
	@Autowired
	private DepositService depositService;
	
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
}
