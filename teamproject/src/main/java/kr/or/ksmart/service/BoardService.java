package kr.or.ksmart.service;

import java.util.List;

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
	
	public List<Board> getBoardList(int currentPage){
		int cnt = boardMapper.getBoardCnt();
		int lastPage = cnt/10 + 1;
		//List<Board> list = boardMapper.getBoardList(cnt-(currentPage-1)*10, cnt-(currentPage-1)*10-10);
		List<Board> list = boardMapper.getBoardList(0, 10);
		return list;
	}
	
	public Board getBoard(String no) {
		Board board = boardMapper.getBoard(no);
		return board;
	}
	
}
