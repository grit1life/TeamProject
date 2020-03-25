package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.DocBill;
import kr.or.ksmart.service.DocBillService;

@Controller
public class DocBillController {

	@Autowired
	private DocBillService docBillService;
	
	@GetMapping("/staff/billList")
	public String billList(Model model) {
		List<DocBill> list = docBillService.getDocBillList();
		model.addAttribute("list", list);
		return "docBill/billList";
	}
	
	@GetMapping("/staff/billForm")
	public String billForm(Model model) {
		
		return "docBill/billForm";
	}
	
	@GetMapping("/staff/depositList")
	public String depositList() {
		return "docBill/depositList";
	}

	
}
