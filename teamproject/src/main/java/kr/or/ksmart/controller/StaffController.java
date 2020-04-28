package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public Map<String, Object> staffLogin(HttpSession session,@RequestParam(value="staffId")String staffId
			,@RequestParam(value="staffPw")String staffPw) {
		
		String result = staffService.staffLogin(staffId,staffPw,session);
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
		System.out.println(staff.toString());
		List<Staff> staffList = staffService.staffList(staff);
		System.out.println("ajax"+staffList.toString());
		return staffList;
	}
	//상세화면
	@GetMapping("/admin/staffList")
	public String adminStaffList(Model model,@RequestParam(value="staffCode")String staffCode) {
		System.out.println(staffCode);
		Staff staffD = staffService.staffDetails(staffCode);
		model.addAttribute("staffD", staffD);
		
		List<Staff> staffT = staffService.staffTransferList(staffCode);
		System.out.println(staffT+"<-staffT");
		model.addAttribute("staffT", staffT);
		
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
	
	@PostMapping("/admin/staffDUpdate")
	public String staffDUpdate(Staff staff, RedirectAttributes model, HttpSession session) {
		//System.out.println("-----------controller-----------------");
		//System.out.println(staff.toString());
		int result = staffService.staffDUpdate(staff, session);//update		
		model.addAttribute("staffCode", staff.getStaffCode());
		String massege = "";
		if(result>0)massege="정상적으로 수정 되었습니다";
		else massege="수정할 수 없었습니다";
		model.addAttribute("result", result);
		return "redirect:staff/adminStaffList";	
	}
	@PostMapping("/admin/staffTUpdate")
	public String staffTUpdate() {
		
		return "/staff/staffList";
	}
	@PostMapping("/admin/staffMoveAdd")
	public String staffMoveAdd() {
		return "/staff/staffList";
	}
	@PostMapping("/admin/staffLeaveUpdate")
	public String staffLeaveUpdate() {
		return "/staff/staffList";
	}
	

	
}
