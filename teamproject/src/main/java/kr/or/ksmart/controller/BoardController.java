package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boardList")
	public String boardList(Model model, @RequestParam(value="page", required = false) String page) {
		if(page==null) {
			page = "1";
		}
		int pageNum = Integer.parseInt(page);
		Map<String, Object> map = boardService.getBoardList(pageNum);
		model.addAttribute("bList", map.get("bList"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("startPage", map.get("startPage"));
		model.addAttribute("endPage", map.get("endPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		
		return "board/boardList";
	}
	
	@GetMapping("/board")
	public String board(Model model, @RequestParam(value = "no") String no) {
		Board board = boardService.getBoard(no);
		model.addAttribute("b", board);
		return "board/board";
	}
	@GetMapping("/writeBoard")
	public String board() {
		return "board/writeBoard";
	}
	
}
