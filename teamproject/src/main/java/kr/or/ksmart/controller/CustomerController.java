package kr.or.ksmart.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.service.CustomerService;



@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	//개인 고객 등록
	@GetMapping("/cInsert")
	public String cInsert() {
		
		
		return "/customer/cInsert";
	}
	//개인 고객 등록 프로세스
    @PostMapping("/cInsert")
	public String cInsert(@RequestParam(value="customerId", required = false) String customerId, Customer customer){
			 
			 
			  int result =customerService.cInsert(customer); 
			  if(result>0) {
				  return "redirect:/cList";
			  }
		 
		  
		  return "redirect:/cList"; }
	
	//개인사업, 거래처 고객 등록
	@GetMapping("/cInsert2")
	public String addCustomer2() {
			
			
		return "/customer/cInsert2";
	}
	
	//개인고객 리스트
	@GetMapping("/cList")
	public String CustomerList(Model model) {
		model.addAttribute("CustomerList", customerService.getCustomerList());
			
		return "/customer/cList";
	}
	
	
	//개인 사업, 법인 고객 리스트
	@GetMapping("/cList2")
	public String CustomerCompanyList(Model model) {
			model.addAttribute("CustomerCompanyList", customerService.getCustomerCompanyList());
				
			return "/customer/cList2";
		}
	
	//개인 고객 상세보기
	@GetMapping("/cUpdate")
	public String CustomerView() {
		
		return "/customer/cUpdate";
	}
	
	
	//개인사업, 법인  고객 상세보기
		@GetMapping("/cUpdate2")
		public String CustomerCompanyView() {
			
			return "/customer/cUpdate2";
		}
	
}
