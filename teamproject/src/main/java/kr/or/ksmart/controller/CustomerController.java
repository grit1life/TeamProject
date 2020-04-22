package kr.or.ksmart.controller;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.service.CustomerService;

	@Controller
	public class CustomerController {
		private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
		
		
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
		
	    @GetMapping("/cList")
		public String CustomerList(Model model, @RequestParam(value="page", required = false) String page) {
			if(page==null) {
				page = "1";
			}
			int pageNum = Integer.parseInt(page);
			Map<String, Object> map = customerService.getCustomerList(pageNum);
			
			model.addAttribute("CustomerList", map.get("CustomerList"));
			model.addAttribute("currentPage", map.get("currentPage"));
			model.addAttribute("startPage", map.get("startPage"));
			model.addAttribute("endPage", map.get("endPage"));
			model.addAttribute("lastPage", map.get("lastPage"));
			
			return "customer/cList";
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
		
		//개인고객 검색(페이징)
		@PostMapping("/getCustomerSearchList")
		public String getCustomerSearchList(  @RequestParam(value="customerId" ,required=false) 		String customerId
												 ,@RequestParam(value="customerName" ,required=false)		String customerName 
												 ,@RequestParam(value="customerClass" ,required=false) 		String customerClass
												 ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
												 ,@RequestParam(value="toDate" ,required=false) 			String toDate													
												 ,@RequestParam(value="page", required = false)             String page
												 ,Model model) {
				
			if(page==null) {
				page = "1";
			}
			int pageNum = Integer.parseInt(page);
			Map<String, Object> map = customerService.getCustomerSearchList(customerId, customerName, customerClass, fromDate, toDate, pageNum);
			
			model.addAttribute("CustomerList", map.get("CustomerList"));
			model.addAttribute("currentPage", map.get("currentPage"));
			model.addAttribute("startPage", map.get("startPage"));
			model.addAttribute("endPage", map.get("endPage"));
			model.addAttribute("lastPage", map.get("lastPage"));
			
			System.out.println(map.get("startPage"));
			return "customer/cList";
			
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
		public String CustomerCompanyList(Model model, @RequestParam(value="page", required = false) String page) {
			if(page==null) {
				page = "1";
			}
			int pageNum = Integer.parseInt(page);
			Map<String, Object> map = customerService.getCustomerCompanyList(pageNum);
			
			model.addAttribute("CustomerCompanyList", map.get("CustomerCompanyList"));
			model.addAttribute("currentPage", map.get("currentPage"));
			model.addAttribute("startPage", map.get("startPage"));
			model.addAttribute("endPage", map.get("endPage"));
			model.addAttribute("lastPage", map.get("lastPage"));
			
			return "customer/cList2";
			}
		
		//개인고객 검색
		@PostMapping("/getCustomerSearchList2")
		public String getCustomerSearchList2( @RequestParam(value="customerId" ,required=false) 		String customerId
											 ,@RequestParam(value="customerCompanyName" ,required=false)String customerCompanyName 
											 ,@RequestParam(value="customerClass" ,required=false) 		String customerClass
											 ,@RequestParam(value="customerLevel" ,required=false) 		String customerLevel
											 ,@RequestParam(value="fromDate" ,required=false) 			String fromDate	
											 ,@RequestParam(value="toDate" ,required=false) 			String toDate													
											 ,@RequestParam(value="page", required = false)             String page
											 ,Model model) {

		if(page==null) {
		page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = customerService.getCustomerSearchList2(customerId, customerCompanyName, customerClass, customerLevel, fromDate, toDate, pageNum);
		
		model.addAttribute("CustomerCompanyList", map.get("CustomerCompanyList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		System.out.println(map.get("startPage"));
		return "customer/cList2";
		
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
			
					
	 //로그인				
	  @PostMapping(value="/customerLogin", produces = "application/json")
	  @ResponseBody
	  public Map<String, Object> customerLogin(HttpSession session,@RequestParam(value="customerId")String customerId,@RequestParam(value="customerPw")String customerPw) {
						String result = customerService.CustomerLogin(customerId, customerPw, session);
						Map<String, Object> Map = new HashMap<String, Object>();
						Map.put("result", result);
						return Map;
					}					
	
	 //로그아웃
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
						session.invalidate();
						return "redirect:/";
		}
					
										
	//마이페이지 조회(값 불러오기)
	@GetMapping("/myView")
	public String myView(Model model) {
		
			model.addAttribute("Customer", customerService.SelectForUpdate());
		
			return "/myPage/myView";
	}	
	
	
	//마이페이지 1:1문의 내역 조회
	@GetMapping("/inquiryHistory")
		public String inquiryHistory(Model model) {
							
			
				return "/myPage/inquiryHistory";
		}			
					
		
	}
