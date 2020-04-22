package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.domain.DocContractForm;
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
	public String pList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = periodicInspectionService.getPeriodicInspectionList(pageNum);
		
		model.addAttribute("PeriodicInspectionList", map.get("PeriodicInspectionList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "periodicInspection/pList";
	}
	
	
	
	
	//상세보기 
	@GetMapping("/pUpdate")
	public String pUpdate(@RequestParam(value="checkCode", required = false) String checkCode
			, Model model) {
		
		model.addAttribute("PeriodicInspection", periodicInspectionService.SelectForUpdate(checkCode));
		
		return "periodicInspection/pUpdate";
	}
	// 수정
	@PostMapping("/pUpdate")
	public String pUpdate(PeriodicInspection periodicInspection) {
				int result = periodicInspectionService.pUpdate(periodicInspection);
				
					return "redirect:/pList";
			}
	//삭제
	@PostMapping("/pDelete")
	public String cDelete(@RequestParam(value="checkCode", required = false) String checkCode){
		periodicInspectionService.pDelte(checkCode);
		return "redirect:/pList";
	}
	
	//검색
	@PostMapping("/periodicInspectionSearchList")
	public String eriodicInspectionSearchList(@RequestParam(value="branchName" ,required=false) 		String branchName
											 ,@RequestParam(value="customerName" ,required=false)		String customerName 
											 ,@RequestParam(value="customerLevel" ,required=false) 		String  customerLevel
											 ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
											 ,@RequestParam(value="toDate" ,required=false) 			String toDate													
											 ,@RequestParam(value="page", required = false)             String page
											 ,Model model) {
			
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = periodicInspectionService.PeriodicInspectionSearchList(branchName, customerName, customerLevel, fromDate, toDate, pageNum);
		
		model.addAttribute("PeriodicInspectionList", map.get("PeriodicInspectionList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		System.out.println(map.get("startPage"));
		return "periodicInspection/pList";
		
		}	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//개인 고객 팝업창  리스트
	@GetMapping("/customerSearchModal")
	public String customerSearchModalList() {
		
		return "periodicInspection/customerSearchModal";
	}
	//기업 고객 팝업창  리스트
	@GetMapping("/customerCompanySearchModal")
	public String customerCompanySearchModalList() {	
			
		return "periodicInspection/customerCompanySearchModal";
		
	}
	//계약서 팝업창 리스트
	@GetMapping("/contractSearchModal")
	public String contractSearchModalList() {	
			
		return "periodicInspection/contractSearchModal";
		
	}
	
	//개인 고객 팝업창 검색 리스트
	@PostMapping("/CustomerSearchList")
	public String CustomerSearchList( @RequestParam(value="customerId",required=false) 		String customerId
										 ,@RequestParam(value="customerName",required=false)String customerName 
										 ,@RequestParam(value="customerClass",required=false) 		String customerClass
										 ,@RequestParam(value="customerCall",required=false) 		String customerCall							         											
										 ,Model model) {
					
					List<Customer> list = periodicInspectionService.CustomerSearchList(customerId,customerName,customerClass,customerCall);				
					model.addAttribute("CustomerList", list);
					return "periodicInspection/customerSearchModal";
				}
	
	//기업고객 팝업창 검색 리스트
	@PostMapping("/CustomerCompanySearchList")
	public String CustomerCompanySearchList(  @RequestParam(value="customerId", required=false) 		String customerId
											 ,@RequestParam(value="customerCompanyName", required=false)String customerCompanyName 
											 ,@RequestParam(value="customerClass", required=false) 		String customerClass
											 ,@RequestParam(value="customerCompanyCall" ,required=false)String customerCompanyCall						         											
											 ,Model model) {
						
		
		List<Customer> list = periodicInspectionService.CustomerCompanySearchList(customerId,customerCompanyName,customerClass,customerCompanyCall);				
						model.addAttribute("CustomerCompanyList", list);
						return "periodicInspection/customerCompanySearchModal";
					}
	
	//계약서 팝업창 검색 리스트
	@PostMapping("/ContractSearchList")
	public String ContractSearchSearchList(      @RequestParam(value="customerId", required=false) 		String customerId
												 ,@RequestParam(value="contractCode", required=false)String contractCode 
												 ,@RequestParam(value="contractNo", required=false)  String contractNo
												 ,@RequestParam(value="goodsName" ,required=false)   String goodsName						         											
												 ,Model model) {
							
			
			List<DocContractForm> list = periodicInspectionService.ContractSearchList(contractCode, contractNo, customerId, goodsName);				
							model.addAttribute("ContractList", list);
							return "periodicInspection/contractSearchModal";
						}	
						


	
	//삭제
	@GetMapping("/pDelete")
	public String pDelete(){
		
		
		return "/periodicInspection/pDelete";
	}
	
	

}
