package kr.or.ksmart.controller;

import java.util.List;

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
		List<Board> bList = boardService.getBoardList(pageNum);
		model.addAttribute("bList", bList);
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
