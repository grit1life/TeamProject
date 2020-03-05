package kr.or.ksmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ksmart.service.BoardService;

@Controller
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		System.out.println(boardService.getBoardList());
		return "index";
	}
}
