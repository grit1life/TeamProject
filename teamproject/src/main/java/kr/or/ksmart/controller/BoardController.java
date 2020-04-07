package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.domain.BoardFile;
import kr.or.ksmart.service.BoardService;
import kr.or.ksmart.service.StorageService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private StorageService storageSevice;
	
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
		List<BoardFile> boardFile =boardService.getBoardFileList(no);
		model.addAttribute("b", board);
		model.addAttribute("bf", boardFile);
		return "board/board";
	}
	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		//파일 다운로드
		Resource file = storageSevice.loadAsResource(filename);
		ResponseEntity<Resource>  re = ResponseEntity.ok().header(
				HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\""
		).body(file);
		return re;
	}
	@GetMapping("/staff/writeBoard")
	public String boardWrite() {
		return "board/writeBoard";
	}
	@PostMapping("/staff/writeBoard")
	public String boardWrite(Board board, @RequestParam(value = "file", required = false) List<MultipartFile> fileList) {
		//boardService.insertBoard(board);
		
		boardService.insertBoard(board, fileList);
		return "redirect:/staff/boardList";
	}

	@GetMapping("/staff/deleteBoard")
	public String deleteBoard(@RequestParam(value = "boardNo") String boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:/staff/boardList";
	}
	@GetMapping("/staff/modifyBoard")
	public String modifyBoard(Model model, @RequestParam(value = "boardNo") String boardNo) {
		Board board = boardService.getBoard(boardNo);
		List<BoardFile> boardFile =boardService.getBoardFileList(boardNo);
		model.addAttribute("b", board);
		model.addAttribute("bf", boardFile);
		return "board/modifyBoard";
	}
	@PostMapping("/staff/modifyBoard")
	public String modifyBoard(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/staff/boardList";
	}
}
