package kr.or.ksmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.service.DocContractFormService;

@Controller
public class DocContractFormController {

	@Autowired
	private DocContractFormService docContractFormService;
	
	@GetMapping("/staff/contractFormList")
	public String staffContractFormList(Model model){
		List<DocContractForm> list = docContractFormService.getContractList();
		model.addAttribute("list", list);
		return "docContract/staffContractFormList";
	}
}
