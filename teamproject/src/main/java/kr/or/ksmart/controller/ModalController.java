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
import kr.or.ksmart.domain.GoodsCount;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.BranchService;
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
	
	@GetMapping("/customerModal")
	public String customerModal(Model model) {
		
		return "modal/customerModal";
	}

	@GetMapping("/addressModal")
	public String addressModal(Model model) {
		
		return "modal/addressModal";
	}
	
	
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
	
	@GetMapping("/goodsSelectModal")
	public String goodsSelectModal(Model model) {
		model.addAttribute("getGoodsCategoryList", goodsCategoryService.getGoodsCategoryList());
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
	@GetMapping("/test")
	public String test() {
		
		return "modal/test";
	}
	@PostMapping("/test")
	public @ResponseBody String testp(GoodsCount goodsCount) {
		System.out.println(goodsCount.getGoodsCode());
		System.out.println("왔다");
		return "test";
	}
	

}
