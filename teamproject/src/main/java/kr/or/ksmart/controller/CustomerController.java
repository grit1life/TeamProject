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
	
	
	//개인 고객 등록
	@GetMapping("/cinsert")
	public String addCustomer() {
		
		
		return "/customer/cinsert";
	}
	
	//개인사업, 거래처 고객 등록
	@GetMapping("/cinsert2")
	public String addCustomer2() {
			
			
		return "/customer/cinsert2";
	}
	
	//개인고객 리스트
	@GetMapping("/clist")
	public String CustomerList(Model model) {
		model.addAttribute("CustomerList", customerService.getCustomerList());
			
		return "/customer/clist";
	}
	
	
	//개인사업, 거래처 고객 리스트
	@GetMapping("/clist2")
	public String CustomerCompanyList(Model model) {
			model.addAttribute("CustomerCompanyList", customerService.getCustomerList());
				
			return "/customer/clist2";
		}
	
	//고객,거래처 상세보기
	@GetMapping("/cupdate")
	public String CustomerView() {
		
		return "/customer/cupdate";
	}
}
