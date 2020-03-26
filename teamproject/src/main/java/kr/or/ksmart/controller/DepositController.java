package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String depositList(Model model) {
		List<Deposit> list = depositService.getDepositList();
		boolean paid = true;
		List<Deposit> paidList = depositService.getDepositList(paid);
		model.addAttribute("list", list);
		model.addAttribute("paidList", paidList);
		return "docBill/depositList";
	}
}
