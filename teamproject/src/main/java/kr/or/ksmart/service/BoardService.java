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
	
	public List<Board> getBoardList(){
		List<Board> list = boardMapper.getBoardList();
		return list;
	}
	
	public Board getBoardList(String no) {
		Board board = boardMapper.getBoardList(no);
		return board;
	}
	
}
