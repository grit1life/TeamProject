package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.Goods;
import kr.or.ksmart.domain.MyCompanyDeposit;
import kr.or.ksmart.domain.Mycompany;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.domain.PriceSet;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.DocContractFormService;
import kr.or.ksmart.service.DocEstimateFormService;
import kr.or.ksmart.service.MyCompanyDepositService;

@Controller
public class DocContractFormController {

	@Autowired
	private DocEstimateFormService docEstimateFormService;
	
	@Autowired
	private DocContractFormService docContractFormService;
	
	@Autowired
	private MyCompanyDepositService myCompanyDepositService;
	
	@GetMapping("/staff/contractFormList")
	public String staffContractFormList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page){
		
		Pagination<List<DocContractForm>> pagination
					= docContractFormService.getContractList(page);
	    List<Staff> staffList = docEstimateFormService.getStaffNameList();
	    List<PriceSet> setList = docEstimateFormService.getSetNameList();
	    List<Goods> goodsList = docEstimateFormService.getGoodsNameList();
		model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		model.addAttribute("staffList", staffList); 
		model.addAttribute("setList", setList);
		model.addAttribute("goodsList", goodsList);
		
		return "docContract/staffContractFormList";
	}
	@GetMapping("/staff/contractFormSearchList")
	public String staffContractFormList(Model model
			, @RequestParam(value="page", required = false, defaultValue = "1") int page
			, DocContractForm docContractForm){
		Pagination<List<DocContractForm>> pagination = docContractFormService.getContractSearchList(page, docContractForm);
	    List<Staff> staffList = docEstimateFormService.getStaffNameList();
	    List<PriceSet> setList = docEstimateFormService.getSetNameList();
	    List<Goods> goodsList = docEstimateFormService.getGoodsNameList();
	    
	    model.addAttribute("list", pagination.getList());
		model.addAttribute("currentPage", pagination.getCurrentPage());
		model.addAttribute("startPage", pagination.getStartPage());
		model.addAttribute("endPage", pagination.getEndPage());
		model.addAttribute("lastPage", pagination.getLastPage());
		model.addAttribute("staffList", staffList); 
		model.addAttribute("setList", setList);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("dc", docContractForm);
		
		return "docContract/staffContractFormSearchList";
	}
	@GetMapping("/customer/contractForm")
	public String staffContractFormList(@RequestParam (value = "contractCode") String contractCode, Model model){
		List<DocContractForm> list = docContractFormService.getContractForm(contractCode);
		Mycompany mycompany = docEstimateFormService.getMycompany();
		MyCompanyDeposit deposit = myCompanyDepositService.getMyCompanyDeposit();
		model.addAttribute("list", list);
		model.addAttribute("mycompany", mycompany);
		model.addAttribute("deposit", deposit);
		return "docContract/contractForm";
	}
}
