package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.service.BoardService;
import kr.or.ksmart.service.BranchService;

@Controller
public class DocContractController {

	@Autowired
	private BranchService branchService;
	
	@GetMapping("/staff/contractInsert")
	public String contractInsert(Model model) {
		List<Branch> branchSerectList = branchService.selectBranch();
		System.out.println(branchSerectList.toString());
		model.addAttribute("branchSerectList", branchSerectList);
		return "docContract/contractInsert";
	}
	@GetMapping("/contractList")
	public String estimateList() {
		
		return "docContract/contractList";
	}
}
