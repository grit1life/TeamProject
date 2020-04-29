package kr.or.ksmart.controller;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.DocContractInsert;
import kr.or.ksmart.service.BoardService;
import kr.or.ksmart.service.BranchService;
import kr.or.ksmart.service.DocContractService;

@Controller
public class DocContractController {

	@Autowired
	private BranchService branchService;
	
	@Autowired
	private DocContractService docContractService;
	
	@GetMapping("")
	public String addressModal() {
		return "";
	}
	//계약서 작성 화면
	@GetMapping("/staff/contractInsert")
	public String contractInsert(Model model) {
		List<Branch> branchSerectList = branchService.selectBranch();
		System.out.println(branchSerectList.toString());
		model.addAttribute("branchSerectList", branchSerectList);
		return "docContract/contractInsert";
	}
	//ajax로 계약서 등록,성공시 Print 화면에 이동
	@PostMapping("/staff/contractInsertAjax")
	public @ResponseBody String contractInsertAjax(@ModelAttribute DocContractInsert docContractInsert, Model model,HttpSession session) {
		//System.out.println("-----------------------contractInsertAjax---------------------");
		//System.out.println(docContractInsert.getStaffCode()+"<-getStaffCode");
		/*
		if(docContractInsert != null) {
			String[] dataArray = docContractInsert.getGoodsCode();
			System.out.println(dataArray[0]);
		}
		*/
		docContractService.contractInsertAjax(docContractInsert,session);
		
		return docContractInsert.getContractCode();
	}
	
	
	@GetMapping("/contractList")
	public String estimateList() {
		
		return "docContract/contractList";
	}
	@PostMapping("/staff/contractInsert")
	public String contractInsert(@RequestParam(value = "a")String A) {
		System.out.println("contractInsertController");
		System.out.println(A);
		return "docContract/contractList";
	}

}
