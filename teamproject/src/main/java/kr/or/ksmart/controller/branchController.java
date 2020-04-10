package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.service.BranchService;


	@Controller
	public class branchController {
		
		@Autowired
		private BranchService branchService;
	    
		//지점등록
		@GetMapping("/bInsert")
		public String bInsert() {
				
				
		return "/branch/bInsert";
		
			
		}
		 @PostMapping("/bInsert")
			public String cInsert(@RequestParam(value="branchCode", required = false) String branchCode, Branch branch){
					 
		    		  System.out.println("binding test = " + branchCode);
		    		  System.out.println(branch.toString());
					  int result =branchService.bInsert(branch); 
					  if(result>0) {
						  return "redirect:/bList";
					  }
				 
				  
				  return "redirect:/bList";
				  }	
		 
		 @GetMapping("/bList")
			public String BranchList(Model model, @RequestParam(value="page", required = false) String page) {
				if(page==null) {
					page = "1";
				}
				int pageNum = Integer.parseInt(page);
				Map<String, Object> map =  branchService.getBranchList(pageNum);
				
				model.addAttribute("BranchList", map.get("BranchList"));
				model.addAttribute("currentPage", map.get("currentPage"));
				model.addAttribute("startPage", map.get("startPage"));
				model.addAttribute("endPage", map.get("endPage"));
				model.addAttribute("lastPage", map.get("lastPage"));
				
				return "branch/bList";
			}
		
		
		//지점 업데이트
		@GetMapping("/bUpdate")
		public String bUpdate(@RequestParam(value="branchCode", required = false) String branchCode
				, Model model) {
			
			model.addAttribute("Branch", branchService.SelectForUpdate(branchCode));
			
			return "/branch/bUpdate";
		}	
		@PostMapping("/bUpdate")
		public String bUpdate(Branch branch) {
			int result = branchService.bUpdate(branch);
			
				return "redirect:/bList";
		}
		//지점 삭제
		@GetMapping("/bDelete")
		public String bDelete(@RequestParam(value="branchCode", required = false) String branchCode							 
						             ,@RequestParam(value="branchName", required = false) String branchName	
						             , Model model) {
					model.addAttribute("branchCode", branchCode);
					model.addAttribute("branchName", branchService.SelectForUpdate(branchCode).getBranchName());
					return "/branch/bDelete";
		}
				
		@PostMapping("/bDelete")
		public String cDelete(@RequestParam(value="branchCode") String branchCode		
									 ,@RequestParam(value="branchName", required = false) String branchName	
						             ,RedirectAttributes redirectA) {
					Branch branch = branchService.SelectForUpdate(branchCode);
					if(branchCode != null && !"".equals(branchCode)
							&& branchCode.equals(branch.getBranchCode())) {
						branchService.bDelte(branchCode, branchName);
						return "redirect:/bList";
						
					}else {
						redirectA.addAttribute("branchName", branchName);
						return "/branch/bDelete";
						
					}
					
		}
				
	    //지점 검색
		@PostMapping("/branchSearchList")
		public String getCustomerSearchList(  @RequestParam(value="branchCode" ,required=false) 		String branchCode
				 ,@RequestParam(value="staffName" ,required=false)		String staffName 
				 ,@RequestParam(value="branchName" ,required=false) 		String branchName
				 ,@RequestParam(value="branchPhone" ,required=false) 		String branchPhone
				 ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
				 ,@RequestParam(value="toDate" ,required=false) 			String toDate													
				 ,@RequestParam(value="page", required = false)             String page
				 ,Model model) {

				if(page==null) {
				page = "1";
				}
				int pageNum = Integer.parseInt(page);
				Map<String, Object> map = branchService.getBranchSearchList(branchCode, staffName, branchName, branchPhone, fromDate, toDate, pageNum);
				
				model.addAttribute("BranchList", map.get("BranchList"));
				model.addAttribute("currentPage", map.get("currentPage"));
				model.addAttribute("startPage", map.get("startPage"));
				model.addAttribute("endPage", map.get("endPage"));
				model.addAttribute("lastPage", map.get("lastPage"));
				
				System.out.println(map.get("startPage"));
				return "/branch/bList";

		}	
							
		
	
	}
