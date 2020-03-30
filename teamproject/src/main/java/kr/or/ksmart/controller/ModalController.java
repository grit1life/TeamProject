package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.GoodsCount;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.BranchService;
import kr.or.ksmart.service.StaffService;

@Controller
public class ModalController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private BranchService branchService;
	
	@GetMapping("/customerModal")
	public String customerModal(Model model) {
		
		return "modal/customerModal";
	}

	@GetMapping("/addressModal")
	public String addressModal(Model model) {
		
		return "modal/addressModal";
	}
	
	
	@GetMapping("/modalStaffList")
	public String modalHtml(Model model
			, @RequestParam(value="foreachNum", required = false, defaultValue = "0") int foreachNum
			, Staff staff ) {
		List<Branch> branchSerectList = branchService.selectBranch();
		//System.out.println(branchSerectList.toString());
		model.addAttribute("branchSerectList", branchSerectList);
		
		List<Staff> staffList = staffService.staffList(staff);
		//System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);
		
		return "modal/staffListModal";
	}
	@PostMapping("/modalStaffList")
	public String modalHtml(Model model
			, Staff staff ) {
		//System.out.println(staff+"<-controller staff");
		List<Staff> staffList = staffService.staffList(staff);
		//System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);

		return "modal/staffListModal2";
	}
	
	@GetMapping("/modalGoodsList")
	public String modalGoodsList() {
		return "modal/goodsModal";
	}
	
	@PostMapping("/modalGoodsList")
	public String modalGoodsList(GoodsCount goodsCount) {
		return "modal/goodsModal2";
	} 
	
	@GetMapping("/modalSetList")
	public String modalSetList() {
		return "modal/setModal";
	}
	

}
