package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		model.addAttribute("allOutcomeList", allOutcomeList);		
		return "statis/rStatis";
	}
}
