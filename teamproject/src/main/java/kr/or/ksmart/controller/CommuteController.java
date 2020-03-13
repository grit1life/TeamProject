package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.service.CommuteService;

@Controller
public class CommuteController {

	@Autowired
	private CommuteService commuteService;
	
	@GetMapping("/staff/commuteList")
	public String commuteList(Model model) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다
		List<Commute> cList = commuteService.CommuteList(staffId);
		model.addAttribute("cList", cList);
		model.addAttribute("staffName", cList.get(0).getStaffName());
		return "commute/commuteList";
	}
	
	
}
