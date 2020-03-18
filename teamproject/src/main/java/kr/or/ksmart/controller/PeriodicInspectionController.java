package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import kr.or.ksmart.service.PeriodicInspectionService;

@Controller
public class PeriodicInspectionController {
	
	@Autowired
	private PeriodicInspectionService periodicInspectionService;
	
	//등록
	@GetMapping("/pInsert")
	public String pInsert() {
		
		
		return "/periodicInspection/pInsert";
	}

	
	//리스트
	@GetMapping("/pList")
	public String pList(Model model) {
		model.addAttribute("PeriodicInspectionList", periodicInspectionService.getPeriodicInspectionList());
		
		return "/periodicInspection/pList";
	}
	
	
	

}
