package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.domain.BoardFile;
import kr.or.ksmart.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private StorageService storageService;
	
	public int deleteBoard(String no) {
		return boardMapper.deleteBoard(no);
	}
	
	
	public int insertBoard(Board board) {
		return boardMapper.insertBoard(board);
	}
	
	public int insertBoard(Board board, List<MultipartFile> fileList) {
		/* board 저장 */
		boardMapper.insertBoard(board);
		
		/* 파일 이름 저장 */
		int boardNo = boardMapper.getLastBoardNo();
		
		int result = 0;
		for(int i=0; i<fileList.size(); i++) {
			if(fileList.get(i).getOriginalFilename()==null || "".equals(fileList.get(i).getOriginalFilename())) {
				break;
			}
			Integer no = boardMapper.getBoardFileNo();
			if(no==null) {
				no = 0;
			}
			no++;
			storageService.store(fileList.get(i), boardNo);
			BoardFile boardFile = new BoardFile();
			boardFile.setBoardFileNo(Integer.toString(no));
			boardFile.setBoardFileUrl(boardNo+"_"+fileList.get(i).getOriginalFilename());
			boardFile.setBoardNo(boardMapper.getLastBoardNo());
			result = boardMapper.insertFileName(boardFile);
		}
		
		return result;
	}
	
	public Map<String, Object> getBoardList(int currentPage){
		int cnt = boardMapper.getBoardCnt();
		int firstClmn = (currentPage-1)*10;
		int lastClmn = firstClmn +10;
		List<Board> bList = boardMapper.getBoardList(firstClmn, lastClmn);
		
		int startPage = currentPage - 5;
		if(startPage<1) {
			startPage = 1;
		}
		int endPage = currentPage + 5;
		int lastPage = cnt/10 + 1;
		if(endPage > lastPage) {
			endPage = lastPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bList", bList);
		map.put("currentPage", currentPage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("lastPage", lastPage);
		
		return map;
	}
	
	public Board getBoard(String no) {
		Board board = boardMapper.getBoard(no);
		boardMapper.viewBoard(no);
		return board;
	}
	public List<BoardFile> getBoardFileList(String boardNo) {
		return boardMapper.getBoardFileList(boardNo);
	}
	public int modifyBoard(Board board) {
		return boardMapper.modifyBoard(board);
	}
	
}
