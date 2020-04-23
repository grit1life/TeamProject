package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.service.AsRepairService;

@Controller
public class AsRepairController {
	
	@Autowired
	private AsRepairService AsRepairService;
	
	
	@GetMapping("/rList")
	public String rInsert(){
		
		
		return "/asRepair/rList";
		
		
	}
	

	//상세보기 
	@GetMapping("/rUpdate")
	public String rUpdate(@RequestParam(value="repairCode", required = false) String repairCode
			,Model model) {
		
		model.addAttribute("AsRepair", AsRepairService.SelectForUpdate(repairCode));
		
		return "/asRepair/rUpdate";
	}

}
