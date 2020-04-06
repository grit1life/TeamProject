package kr.or.ksmart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.PeriodicInspection;
import kr.or.ksmart.service.PeriodicInspectionService;

@Controller
public class PeriodicInspectionController {
	
	@Autowired
	private PeriodicInspectionService periodicInspectionService;
	
	//등록
	@GetMapping("/pInsert")
	public String pInsert(Model model) {
		model.addAttribute("CustomerList", periodicInspectionService.CustomerList());
		
		return "/periodicInspection/pInsert";
	}
	@PostMapping("/pInsert")
	public String pInsert(PeriodicInspection periodicInspection) {
		
		periodicInspectionService.pInsert(periodicInspection);
		
		return "redirect:/pList";
	}

	
	//리스트
	@GetMapping("/pList")
	public String pList(Model model) {
		model.addAttribute("PeriodicInspectionList", periodicInspectionService.getPeriodicInspectionList());
		
		return "/periodicInspection/pList";
	}
	
	@GetMapping("/customerSearchModal")
	public String customerSearchModalList() {		
		
		return "/periodicInspection/customerSearchModal";
	}
	//개인고객 모달창 검색 리스트
	@PostMapping("/CustomerSearchList")
	public String CustomerSearchList( @RequestParam(value="customerId" ,required=false) 		String customerId
										 ,@RequestParam(value="customerName" ,required=false)String customerName 
										 ,@RequestParam(value="customerClass" ,required=false) 		String customerClass
										 ,@RequestParam(value="customerCall" ,required=false) 		String customerCall							         											
										 ,Model model) {
					
					List<Customer> list = periodicInspectionService.CustomerSearchList(customerId, customerName, customerClass, customerCall);				
					model.addAttribute("CustomerList", list);
					return "/periodicInspection/customerModal";
				}	
						

		
	
	//상세보기
	
	@GetMapping("/pUpdate")
	public String pUpdate(){
		
		
		return "/periodicInspection/pUpdate";
	}
	
	
	//삭제
	@GetMapping("/pDelete")
	public String pDelete(){
		
		
		return "/periodicInspection/pDelete";
	}
	
	

}
