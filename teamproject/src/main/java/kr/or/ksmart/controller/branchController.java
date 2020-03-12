package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.service.BranchService;


	@Controller
	public class branchController {
		
		@Autowired
		private BranchService branchService;
	    
		//지점등록
		@GetMapping("/binsert")
		public String addBranch() {
				
				
		return "/branch/binsert";
		
			
		}
		
		//지점등록
		@GetMapping("/blist")
		public String BranchList(Model model) {
			
			model.addAttribute("BranchList", branchService.getBranchList());
						
						
		return "/branch/blist";
				
					
		}
		
		
		
	
	}
