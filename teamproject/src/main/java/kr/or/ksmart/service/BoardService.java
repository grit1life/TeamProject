package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Board;
import kr.or.ksmart.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	public int insertBoard(Board board) {
		return boardMapper.insertBoard(board);
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
		return board;
	}
	
}
