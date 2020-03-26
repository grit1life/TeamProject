package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Deposit;
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
	public String depositList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = depositService.getDepositList(page);
		boolean paid = true;
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		List<Deposit> paidList = depositService.getDepositList(paid);
		model.addAttribute("list", list);
		model.addAttribute("paidList", paidList);
		return "docBill/depositList";
	}
}
