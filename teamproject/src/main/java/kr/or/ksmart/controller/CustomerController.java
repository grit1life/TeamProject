package kr.or.ksmart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.or.ksmart.service.CustomerService;


@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	//고객,거래처 등록
	@GetMapping("/cinsert")
	public String addCustomer() {
		
		
		return "/customer/cinsert";
	}
	
	//고객,거래처 리스트
	@GetMapping("/clist")
	public String CustomerList(Model model) {
		model.addAttribute("CustomerList", customerService.getCustomerList());
			
		return "/customer/clist";
	}
}
