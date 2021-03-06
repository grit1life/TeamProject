package kr.or.ksmart.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/staff/boardList")
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
	
	@GetMapping("/staff/board")
	public String board(Model model, @RequestParam(value = "no") String no) {
		Board board = boardService.getBoard(no);
		model.addAttribute("b", board);
		return "board/board";
	}
	@GetMapping("/staff/writeBoard")
	public String boardWrite() {
		return "board/writeBoard";
	}
	@PostMapping("/staff/writeBoard")
	public String boardWrite(Board board) {
		boardService.insertBoard(board);
		return "board/boardList";
	}
	@GetMapping("/staff/deleteBoard")
	public String deleteBoard(@RequestParam(value = "boardNo") String boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:/staff/boardList";
	}
	@GetMapping("/staff/modifyBoard")
	public String modifyBoard(Model model, @RequestParam(value = "boardNo") String boardNo) {
		Board board = boardService.getBoard(boardNo);
		model.addAttribute("b", board);
		System.out.println(board.getBoardNo()+"+++++++++++++++");
		return "board/modifyBoard";
	}
	@PostMapping("/staff/modifyBoard")
	public String modifyBoard(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/staff/boardList";
	}
}
