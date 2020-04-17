package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.AsExchange;
import kr.or.ksmart.service.AsExchangeService;

@Controller
public class AsExchangeController {
	
	@Autowired
	private AsExchangeService AsExchangeService;
	
		//상세보기 
		@GetMapping("/eUpdate")
		public String eUpdate(@RequestParam(value="exchangeCode", required = false) String exchangeCode
				,Model model) {
			
			model.addAttribute("AsExchange", AsExchangeService.SelectForUpdate(exchangeCode));
			
			return "asExchange/eUpdate";
		}
		// 수정
		@PostMapping("/eUpdate")
		public String eUpdate(AsExchange AsExchange) {
					int result = AsExchangeService.pUpdate(AsExchange);
					
						return "redirect:/aList";
				}
		
	}


