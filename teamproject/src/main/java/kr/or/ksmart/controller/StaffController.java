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

import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping("/staffLogin")
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

	@GetMapping("/staffInsert")
	public String staffInsert() {
		return "staff/staffInsert";
	}
	
	@GetMapping("/staffList")
	public String staffList(Model model) {
		List<Staff> staffList = staffService.staffList();
		System.out.println(staffList.toString());
		model.addAttribute("staffList", staffList);
		return "staff/staffList";
	}
	
	@GetMapping("/admin/staffList")
	public String adminStaffList(Model model) {
		return "staff/adminStaffList";
	}
	
	@GetMapping("/admin/staffDtails")
	public String adminStaffDtails(Model model) {
		return "staff/adminStaffDtails";
	}
	
	@GetMapping("/admin/staffUpdate")
	public String adminStaffUpdate(Model model) {
		return "staff/staffUpdate";
	}
	
	@PostMapping("/admin/staffUpdateConfirmation")
	public String staffUpdateConfirmation(Model model) {
		return "staff/staffUpdateConfirmation";
	}
	
}
