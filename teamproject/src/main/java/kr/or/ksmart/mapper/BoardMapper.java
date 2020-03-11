package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Board;

@Mapper
public interface BoardMapper {
	
	public int getBoardCnt();
	
	public List<Board> getBoardList(int startClmn, int endClmn);

	public Board getBoard(String no);
	
	public int insertBoard(Board board);
}
