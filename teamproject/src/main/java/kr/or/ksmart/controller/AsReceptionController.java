package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.AsReceptionService;


@Controller
public class AsReceptionController {
	
	@Autowired
	private AsReceptionService AsReceptionService;
	
	@GetMapping("/aInsert")
	public String aInsert(){
		
		
		return "/asReception/aInsert";
		
		
	}
	
	@GetMapping("/aList")
	public String aList(Model model){
		
		
		return "/asReception/aList";
		
		
	}
	
	//지점 팝업창  리스트
	@GetMapping("/branchSearchModal")
	public String branchModalList(Model model) {	
		
			model.addAttribute("BranchList", AsReceptionService.getBranchList()); 
		   
			return "/asReception/branchSearchModal";
		}
	//직원 팝업창  리스트
	@GetMapping("/staffSearchModal")
	public String staffModalList(Model model) {	
			
			model.addAttribute("StaffList", AsReceptionService.getStaffList()); 
			   
			return "/asReception/staffSearchModal";
		}
	//지점 팝업창 검색 리스트
	@PostMapping("/BranchSearchList")
	public String branchSearchModalList(
								    @RequestParam(value="branchName", required=false) String branchName
								   ,Model model) {
											
					
					List<Branch> list = AsReceptionService.getBranchSearchList(branchName);
					model.addAttribute("BranchList", list);
					
					return "asReception/branchSearchModal"; 
				}
	//직원 팝업창 검색 리스트
	@PostMapping("/StaffSearchList")
	public String staffSearchModalList(
									    @RequestParam(value="branchName", required=false) String branchName
									   ,@RequestParam(value="staffName", required=false) String  staffName
									   ,Model model) {
												
						
						List<Staff> list = AsReceptionService.getStaffSearchList(branchName, staffName);
						model.addAttribute("StaffList", list);
						
						return "asReception/staffSearchModal"; 
					}
	
	

}
