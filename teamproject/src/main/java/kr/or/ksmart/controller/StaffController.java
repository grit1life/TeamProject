package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Branch;
import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.BranchService;
import kr.or.ksmart.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@Autowired
	private BranchService branchService;
	
	@GetMapping("/staff/staffLogin")
	public String staffLogin() {
		return "staff/staffLogin";
	}
	
	@PostMapping(value="/staffLogin", produces = "application/json")
	@ResponseBody
	public Map<String, Object> staffLogin(HttpSession session,@RequestParam(value="staffId")String staffId,@RequestParam(value="staffPw")String staffPw) {
		String result = staffService.staffLogin(staffId,staffPw,session);
		System.out.println("service ok / StaffController");
		Map<String, Object> loginMap = new HashMap<String, Object>();
		loginMap.put("result", result);
		return loginMap;
	}

	@GetMapping("/admin/staffInsert")
	public String staffInsert() {
		return "staff/staffInsert";
	}
	@PostMapping("/admin/staffInsertConfirmation")
	public String staffInsertConfirmation() {
		return "staff/staffInsertConfirmation";
	}
	
	@GetMapping("/staff/staffList")
	public String staffList(Model model) {
		List<Branch> branchSerectList = branchService.selectBranch();
		System.out.println(branchSerectList.toString());
		model.addAttribute("branchSerectList", branchSerectList);

		List<Staff> staffList = staffService.staffList();
		System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);
		return "staff/staffList";
	}
	
	@PostMapping(value="/staff/staffList", produces = "application/json")
	@ResponseBody
	public List<Staff> staffList(Staff staff) {
		System.out.println("ajax 왔다");
		List<Staff> staffList = staffService.staffList();
		System.out.println("ajax"+staffList.toString());
		
		return staffList;
	}
	
	@GetMapping("/admin/staffList")
	public String adminStaffList(Model model) {
		return "staff/adminStaffList";
	}
	
	@GetMapping("/admin/staffDtails")
	public String StaffDtails(Model model) {
		return "staff/adminStaffDtails";
	}
	
	@GetMapping("/admin/staffUpdate")
	public String StaffUpdate(Model model) {
		return "staff/staffUpdate";
	}
	@PostMapping("/admin/staffUpdateConfirmation")
	public String staffUpdateConfirmation(Model model) {
		return "staff/staffUpdateConfirmation";
	}
	
	@GetMapping("/admin/staffChangeUpdate")
	public String staffChangeUpdate(Model model) {
		return "staff/staffChangeUpdate";
	}
	@PostMapping("/admin/staffChangeUpdateConfirmation")
	public String staffChangeUpdateConfirmation(Model model) {
		return "staff/staffChangeUpdateConfirmation";
	}
	

	
}
