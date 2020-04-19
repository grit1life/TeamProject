package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BoardFile {
	private String boardFileNo;
	private String boardFileUrl;
	private int boardNo;
}
