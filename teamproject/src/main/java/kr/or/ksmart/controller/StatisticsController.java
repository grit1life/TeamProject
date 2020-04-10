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

import kr.or.ksmart.domain.Grade;
import kr.or.ksmart.domain.Outcome;
import kr.or.ksmart.service.StatisticService;

@Controller
public class StatisticsController {
	
	@Autowired
	private StatisticService statisService;
	
	@GetMapping("/staff/cStatis")
	public String cStatis(Model model) {
		List<Grade> gradeList = statisService.getGradeForStatis();
		model.addAttribute("gradeList", gradeList);
		return "statis/cStatis";
	}
	@GetMapping("/staff/rStatis")
	public String rStatis(Model model) {
		List<Outcome> allOutcomeList = statisService.getAllOutCome();
		List<Outcome> PersnlOutcomeList = statisService.getPersonalOutcome();
		List<Outcome> branchOutcomeList = statisService.getBranchOutcome();
		List<Outcome> branchNameList = statisService.getBranchNameList();
		List<Outcome> branchStaffList = statisService.getBranchStaff();
		model.addAttribute("allOutcomeList", allOutcomeList);		
		model.addAttribute("PersnlOutcomeList", PersnlOutcomeList);	
		model.addAttribute("branchOutcomeList", branchOutcomeList);	
		model.addAttribute("branchNameList", branchNameList);	
		model.addAttribute("branchStaffList", branchStaffList);	
		return "statis/rStatis";
	}
	
	@GetMapping("/staff/cDisuse")
	public String cDisuse(Model model) {
		return "statis/cDisuse";
	}
	@GetMapping("/staff/cReCont")
	public String cReCont(Model model) {
		return "statis/cReCont";
	}
	@GetMapping("/staff/cRetrunDelay")
	public String cRetrunDelay(Model model) {
		return "statis/cRetrunDelay";
	}
	
	@PostMapping("/staff/ajaxStatic")
	public @ResponseBody Map<String, Object> getAjaxStatic(@RequestBody Map<String, Object> map) {
		List<Outcome> aList = statisService.getAllPeriodOutCome(map);   //가져올 정보
		List<Outcome> bList = statisService.getBranchPeriodOutcome(map);   //가져올 정보
		List<Outcome> pList = statisService.getPersnlPeriodOutcome(map);   //가져올 정보
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("aList", aList);
		resultMap.put("bList", bList);
		resultMap.put("pList", pList);
		return resultMap; 
	} 
	
	@PostMapping("/staff/ajaxStaticYear")
	public @ResponseBody Map<String, Object> getAjaxYearStatic(@RequestBody Map<String, Object> map) {
		List<Outcome> aList = statisService.getAllPYearOutCome(map);   //가져올 정보
		List<Outcome> bList = statisService.getBranchPYearOutcome(map);   //가져올 정보
		List<Outcome> pList = statisService.getPersnlPYearOutcome(map);   //가져올 정보
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("aList", aList);
		resultMap.put("bList", bList);
		resultMap.put("pList", pList);
		return resultMap; 
	} 
	

}
