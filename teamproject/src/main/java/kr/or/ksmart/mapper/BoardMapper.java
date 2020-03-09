package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> getBoardList();

	public Board getBoardList(String no);
	
}
