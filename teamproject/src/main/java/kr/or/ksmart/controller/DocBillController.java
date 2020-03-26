package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.DocBill;
import kr.or.ksmart.domain.MyCompanyDeposit;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.service.DocBillService;
import kr.or.ksmart.service.DocEstimateFormService;
import kr.or.ksmart.service.MyCompanyDepositService;

@Controller
public class DocBillController {

	@Autowired
	private DocBillService docBillService;
	
	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@Autowired
	private MyCompanyDepositService myCompanyDepositService;
	
	@GetMapping("/staff/billList")
	public String billList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = docBillService.getDocBillList(pageNum);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		return "docBill/billList";
	}
	
	@GetMapping("/staff/billForm")
	public String billForm(Model model, @RequestParam(value = "billCode") String billCode) {
		DocBill docBill = docBillService.getDocBillForm(billCode);
		Mycompany mycompany = docEstimateFormService.getMycompany();
		MyCompanyDeposit myCompanyDeposit = myCompanyDepositService.getMyCompanyDeposit();
		model.addAttribute("docBill", docBill);
		model.addAttribute("mycompany", mycompany);
		model.addAttribute("myComDeposit", myCompanyDeposit);
		return "docBill/billForm";
	}
}
