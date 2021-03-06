package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Holiday;
import kr.or.ksmart.service.CommuteService;

@Controller
public class CommuteController {

	@Autowired
	private CommuteService commuteService;
	
	@GetMapping("/staff/commuteList")
	public String commuteList() {
		return "commute/commuteList";
	}

	@PostMapping("/staff/commuteList")
	public @ResponseBody Map<String, Object> geAjaxCommuteList(@RequestBody Map<String, Object> paramMap) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다

		int currentPage = (Integer)paramMap.get("currentPage");
		Map<String, Object> resultMap = commuteService.CommuteList(staffId, currentPage);
		return resultMap;
	}
	
	@GetMapping("/staff/holidayRegist")
	public String holidayRegist(Model model) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다
		List<Holiday> hList = commuteService.getHolidayList(staffId);
		model.addAttribute("hList", hList);
		return "commute/holidayRegist";
	}
}
