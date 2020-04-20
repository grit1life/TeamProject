package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.classic.Logger;
import kr.or.ksmart.domain.Commute;
import kr.or.ksmart.domain.Holiday;
import kr.or.ksmart.domain.Pagination;
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
	public @ResponseBody Pagination<List<Commute>> geAjaxCommuteList(@RequestParam (value = "currentPage") int currentPage) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다
		Pagination<List<Commute>> p = commuteService.CommuteList(staffId, currentPage);
		
		return p;
	}
	
	@GetMapping("/staff/holidayRegist")
	public String holidayRegist(Model model) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다
		List<Holiday> hList = commuteService.getHolidayList(staffId);
		List<Holiday> hNowList = commuteService.getHolidayListNow(staffId);
		model.addAttribute("hList", hList);
		model.addAttribute("hNowList", hNowList);
		return "commute/holidayRegist";
	}
	@PostMapping("/staff/holidayRegist")
	public String holidayRegist(Holiday holiday, RedirectAttributes redirectA) {
		String staffId = "201804_0001";  //임시값 로그인시 세션의 값을 담아주어야 한다
		holiday.setStaffId(staffId);
		commuteService.insertHoliday(holiday);
		return "redirect:/staff/holidayRegist";
	}
	@GetMapping("/staff/holidayDelete")
	public String holidayDelete(@RequestParam(value="hCode") String hCode, RedirectAttributes redirectA) {
		commuteService.deleteHoliday(hCode);		
		return "redirect:/staff/holidayRegist";
	}
}
