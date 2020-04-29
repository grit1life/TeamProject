package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.domain.AsRepair;
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
	// 수정
	@PostMapping("/rUpdate")
	public String rUpdate(AsRepair AsRepair) {
						int result = AsRepairService.rUpdate(AsRepair);
						
							return "redirect:/aList";
					}
	//삭제
	@PostMapping("/rDelete")
	public String rDelete(@RequestParam(value="receptionCode", required = false) String receptionCode){
				AsRepairService.rDelte(receptionCode);
				return "redirect:/aList";
			}
	

	
}
