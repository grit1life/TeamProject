package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.DocBill;
import kr.or.ksmart.domain.MyCompanyDeposit;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.domain.Pagination;
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
	public String billList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page) {
		
		Pagination<List<DocBill>> pagination = docBillService.getDocBillList(page);
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		return "docBill/billList";
	}
	@GetMapping("/staff/billSearchList")
	public String billSearchList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			, DocBill docBill) {

		Pagination<List<DocBill>> pagination = docBillService.getDocBillSearchList(page, docBill);
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		model.addAttribute("docBill", docBill);
		return "docBill/billSearchList";
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
