package kr.or.ksmart.controller;

import java.util.Map;

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
					int result = AsExchangeService.eUpdate(AsExchange);
					
						return "redirect:/aList";
				}
		//삭제
		@PostMapping("/eDelete")
		public String eDelete(@RequestParam(value="receptionCode", required = false) String receptionCode){
			AsExchangeService.eDelte(receptionCode);
			return "redirect:/aList";
		}
		
		
		//검색
		@PostMapping("/AsExchangeSearchList")
		public String AsExchangeSearchList(       @RequestParam(value="work" ,required=false) 					String work
												 ,@RequestParam(value="workingSituation" ,required=false) 		String workingSituation
												 ,@RequestParam(value="branchName" ,required=false)		        String branchName
												 ,@RequestParam(value="customerName" ,required=false) 		    String customerName
												 ,@RequestParam(value="staffName" ,required=false) 			    String staffName
												 ,@RequestParam(value="toDate" ,required=false) 			    String toDate													
												 ,@RequestParam(value="fromDate", required = false)             String fromDate
												 ,@RequestParam(value="page", required = false)                 String page
												 ,Model model) {
				
			if(page==null) {
				page = "1";
			}
			int pageNum = Integer.parseInt(page);
			Map<String, Object> map = AsExchangeService.AsExchangeSearchList(work,workingSituation, customerName, branchName, staffName, fromDate, toDate, pageNum);
			
			model.addAttribute("AsExchangeList", map.get("AsExchangeList"));
			model.addAttribute("currentPage", map.get("currentPage"));
			model.addAttribute("startPage", map.get("startPage"));
			model.addAttribute("endPage", map.get("endPage"));
			model.addAttribute("lastPage", map.get("lastPage"));
			
			System.out.println(map.get("startPage"));
			return "asReception/aList";
			
			}	
		
	}


