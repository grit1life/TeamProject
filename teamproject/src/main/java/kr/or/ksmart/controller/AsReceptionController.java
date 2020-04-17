package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.PeriodicInspection;
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
	@PostMapping("/aInsert")
	public String eInsert(AsExchange AsExchange) {
		
		AsReceptionService.aInsert(AsExchange);
		
		return "/asReception/aInsert";
	}
		
	@GetMapping("/aList")
	public String aList(Model model, @RequestParam(value="page", required = false) String page){
			if(page==null) {
				page = "1";
			}
			int pageNum = Integer.parseInt(page);
			Map<String, Object> map = AsReceptionService.getAsExchangeList(pageNum);
			Map<String, Object> map2 = AsReceptionService.getAsRepairList(pageNum);
			
			model.addAttribute("AsExchangeList", map.get("AsExchangeList"));
			model.addAttribute("currentPage", map.get("currentPage"));
			model.addAttribute("startPage", map.get("startPage"));
			model.addAttribute("endPage", map.get("endPage"));
			model.addAttribute("lastPage", map.get("lastPage"));
			model.addAttribute("AsRepairList", map2.get("AsRepairList"));
			model.addAttribute("currentPage", map2.get("currentPage"));
			model.addAttribute("startPage", map2.get("startPage"));
			model.addAttribute("endPage", map2.get("endPage"));
			model.addAttribute("lastPage", map2.get("lastPage"));
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
