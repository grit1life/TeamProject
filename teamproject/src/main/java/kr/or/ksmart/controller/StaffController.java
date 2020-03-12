package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.StaffService;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@GetMapping("/staffLogin")
	public String staffLogin() {
		return "staff/login";
	}
	
	@PostMapping("/staffLogin")
	public String staffLogin(@RequestParam(value="staffId")String staffId,@RequestParam(value="staffPw")String staffPw) {
		String staffPwO = staffService.staffLogin(staffId);
		return "/";
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
	
}
