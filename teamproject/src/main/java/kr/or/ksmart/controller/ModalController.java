package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.CompanyModal;
import kr.or.ksmart.domain.CustomerModal;
import kr.or.ksmart.domain.GoodsCount;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.BranchService;
import kr.or.ksmart.service.DocContractService;
import kr.or.ksmart.service.GoodsCategoryService;
import kr.or.ksmart.service.GoodsCountService;
import kr.or.ksmart.service.StaffService;

@Controller
public class ModalController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private GoodsCountService goodsCountService;
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@Autowired
	private DocContractService docContractService;

	/*************************************
	 * 고객 검색 modal
	 * 
	 *************************************/
	@GetMapping("/staff/customerLevelModal")
	public String customerLevelModal() {
		return "modal/customerLevelModal";
	}
	@GetMapping("/staff/customerSelectModal")
	public String customerSelectModal(Model model) {
		List<CustomerModal> customerList = docContractService.customerModalList();
		model.addAttribute("customerList", customerList);
		return "modal/customerSelectModal";
	}
	@PostMapping("/staff/customerListModal")
	public String customerListModal(@ModelAttribute CustomerModal customerModal,Model model) {
		System.out.println(customerModal+"<-customerModal");
		List<CustomerModal> customerList = docContractService.customerModalList(customerModal);
		model.addAttribute("customerList", customerList);
		return "modal/customerListModal";
	}
	
	@GetMapping("/staff/companySelectModal")
	public String companyModalList(Model model) {
		System.out.println("********************@GetMapping(\"/staff/companySelectModal\")*******************************");
		List<CompanyModal> companyList = docContractService.companyModalList();
		System.out.println(companyList+"<-companyList");
		model.addAttribute("companyList", companyList);
		return "modal/companySelectModal";
	}
	@PostMapping("/staff/companyListModal")
	public String companyModalList(@ModelAttribute CompanyModal companyModal,Model model) {
		System.out.println("********************@PostMapping(\"/staff/companySelectModal\")*******************************");
		System.out.println(companyModal+"<-companyModal");
		List<CompanyModal> companyList = docContractService.companyModalList(companyModal);
		model.addAttribute("companyList", companyList);
		return "modal/companyListModal";
	}
	/*************************************
	 * 배송지 주소 입력 modal
	 * 
	 *************************************/
	@GetMapping("/addressModal")
	public String addressModal(Model model) {
		
		return "modal/addressModal";
	}
	/*************************************
	 * 담당자 검색 modal
	 * 
	 *************************************/
	@GetMapping("/staffSelectModal")
	public String modalHtml(Model model
			, @RequestParam(value="foreachNum", required = false, defaultValue = "0") int foreachNum
			, Staff staff ) {
		List<Branch> branchSerectList = branchService.selectBranch();
		//System.out.println(branchSerectList.toString());
		model.addAttribute("branchSerectList", branchSerectList);
		
		List<Staff> staffList = staffService.staffList(staff);
		//System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);
		
		return "modal/staffSelectModal";
	}
	@PostMapping("/staffListModal")
	public String modalHtml(Model model
			, Staff staff ) {
		//System.out.println(staff+"<-controller staff");
		List<Staff> staffList = staffService.staffList(staff);
		//System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);

		return "modal/staffListModal";
	}
	/*************************************
	 * 상품 검색 modal
	 * 
	 *************************************/
	@GetMapping("/goodsSelectModal")
	public String goodsSelectModal(Model model) {
		model.addAttribute("getGoodsCategoryList", goodsCategoryService.getGoodsCategoryList());
		List<GoodsCount> goodsCountList = goodsCountService.goodscount();
		model.addAttribute("goodsCountList", goodsCountList);
		return "modal/goodsSelectModal";
	}
	
	@PostMapping("/goodsListModal")
	public String goodsListModal(Model model,GoodsCount goodsCount) {
		System.out.println(goodsCount.toString()+"form로 받는 값");
		System.out.println(goodsCount.getGoodsCode());
		List<GoodsCount> goodsCountList = goodsCountService.goodscount(goodsCount);
		model.addAttribute("goodsCountList", goodsCountList);
		return "modal/goodsListModal";
	} 
	/*************************************
	 * 세트 검색 modal
	 * 
	 *************************************/
	@GetMapping("/setSelectModal")
	public String setSelectModal(Model model) {
		//Category selectBox의 값을 가지고 오기
		model.addAttribute("getGoodsCategoryList", goodsCategoryService.getGoodsCategoryList());
		return "modal/setSelectModal";
	}
	
	@PostMapping("/setListModal")
	public String setListModal(Model model,GoodsCount goodsCount) {
		System.out.println(goodsCount.toString()+"form로 받는 값");
		List<GoodsCount> setCountList = goodsCountService.setCount(goodsCount);
		model.addAttribute("setCountList", setCountList);
		return "modal/setListModal";
	} 
}
