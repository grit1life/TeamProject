package kr.or.ksmart.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
	    @PostMapping("/cInsert")
		public String cInsert(@RequestParam(value="customerId", required = false) String customerId, Customer customer){
				 
	    		  System.out.println("binding test = " + customerId);
	    		  System.out.println(customer.toString());
				  int result =customerService.cInsert(customer); 
				  if(result>0) {
					  return "/customer/cInsert";
				  }

			  return "/customer/cInsert";
			  }	
		
		
		//개인 고객 리스트
		@GetMapping("/cList")
		public String CustomerList(Model model) {
			model.addAttribute("CustomerList", customerService.getCustomerList());
				
			return "/customer/cList";
		}
		
		//개인 고객 업데이트(값 불러오기)
		@GetMapping("/cUpdate")
		public String CustomerView(@RequestParam(value="customerId", required = false) String customerId
				, Model model) {
			
			model.addAttribute("Customer", customerService.SelectForUpdate(customerId));
			
			return "/customer/cUpdate";
		}
		
		//개인고객 업데이트(값 수정)
		@PostMapping("/cUpdate")
		public String cUpdate(Customer customer) {
			int result = customerService.cUpdate(customer);
			
				return "redirect:/cList";
		}
				
		//개인고객 삭제
		@GetMapping("/cDelete")
		public String cDelete(@RequestParam(value="customerId", required = false) String customerId							 
				             ,@RequestParam(value="customerName", required = false) String customerName	
				             , Model model) {
			model.addAttribute("customerId", customerId);
			model.addAttribute("customerName", customerService.SelectForUpdate(customerId).getCustomerName());
			return "/customer/cDelete";
		}
		
		@PostMapping("/cDelete")
		public String cDelete(@RequestParam(value="customerId") String customerId	
							 ,@RequestParam(value="customerName", required = false) String customerName		
				             ,RedirectAttributes redirectA) {
			Customer customer = customerService.SelectForUpdate(customerId);
			if(customerId != null && !"".equals(customerId)
					&& customerId.equals(customer.getCustomerId())) {
				customerService.cDelte(customerId, customerName);
				return "redirect:/cList";
				
			}else {
				redirectA.addAttribute("customerName", customerName);
				return "/customer/cDelete";
				
			}
			
		}
		
		//개인고객 검색
		@PostMapping("/getCustomerSearchList")
			public String getCustomerSearchList(  @RequestParam(value="customerId" ,required=false) 		String customerId
												 ,@RequestParam(value="customerName" ,required=false)		String customerName 
												 ,@RequestParam(value="customerClass" ,required=false) 		String customerClass
												 ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
												 ,@RequestParam(value="toDate" ,required=false) 			String toDate												
												 ,Model model) {
				
				List<Customer> list = customerService.getCustomerSearchList(customerId, customerName, customerClass, fromDate, toDate);				
				model.addAttribute("CustomerList", list);
				return "/customer/cList";
			}	
					
				
		//개인사업, 거래처 고객 등록
		@PostMapping("/cInsert2")
			public String cInsert2(@RequestParam(value="customerId", required = false) String customerId, Customer customer){
					 
		    		  System.out.println("binding test = " + customerId);
		    		  System.out.println(customer.toString());
					  int result =customerService.cInsert2(customer); 
					  if(result>0) {
						  return "/customer/cInsert";
					  }
				 
				  
				  return "/customer/cInsert";
				  }	
	
		
		//개인 사업, 법인 고객 리스트
		@GetMapping("/cList2")
		public String CustomerCompanyList(Model model) {
				model.addAttribute("CustomerCompanyList", customerService.getCustomerCompanyList());
					
				return "/customer/cList2";
			}
		
		//개인고객 검색
		@PostMapping("/getCustomerSearchList2")
		public String getCustomerSearchList2( @RequestParam(value="customerId" ,required=false) 		String customerId
											 ,@RequestParam(value="customerName" ,required=false)		String customerName 
											 ,@RequestParam(value="customerClass" ,required=false) 		String customerClass
											 ,@RequestParam(value="customerLevel" ,required=false) 		String customerLevel
								             ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
											 ,@RequestParam(value="toDate" ,required=false) 			String toDate												
											 ,Model model) {
						
						List<Customer> list = customerService.getCustomerSearchList2(customerId, customerName, customerClass, customerLevel, fromDate, toDate);				
						model.addAttribute("CustomerCompanyList", list);
						return "/customer/cList2";
					}	
							
	
		//개인사업, 법인  고객 업데이트(값 불러오기)
			@GetMapping("/cUpdate2")
			public String CustomerView2(@RequestParam(value="customerId", required = false) String customerId
					, Model model) {
				
				model.addAttribute("Customer", customerService.SelectForUpdate2(customerId));
				
				return "/customer/cUpdate2";
			}
			
		//개인사업, 법인 업데이트(값 수정)
			@PostMapping("/cUpdate2")
			public String cUpdate2(Customer customer) {
						int result = customerService.cUpdate2(customer);
						
							return "redirect:/cList2";
					}
			
			//개인사업, 법인 삭제
					@GetMapping("/cDelete2")
					public String cDelete2(@RequestParam(value="customerId", required = false) String customerId							 
				             ,@RequestParam(value="customerName", required = false) String customerName	
				             , Model model) {
						model.addAttribute("customerId", customerId);
						model.addAttribute("customerName", customerService.SelectForUpdate2(customerId).getCustomerName());
						
						return "/customer/cDelete2";
					}
					@PostMapping("/cDelete2")
					public String cDelete2(@RequestParam(value="customerId") String customerId	
										 ,@RequestParam(value="customerName", required = false) String customerName		
							             ,RedirectAttributes redirectA) {
						Customer customer2 = customerService.SelectForUpdate2(customerId);
						if(customerId != null && !"".equals(customerId)
								&& customerId.equals(customer2.getCustomerId())) {
							customerService.cDelte2(customerId, customerName);
							return "redirect:/cList2";
							
						}else {
							redirectA.addAttribute("customerName", customerName);
							return "/customer/cDelete2";
							
						}
						
					}
		
	}
