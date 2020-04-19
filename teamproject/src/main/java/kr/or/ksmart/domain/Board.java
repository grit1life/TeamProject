package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Board {
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String staffName;
	private String boardWrtDate;
	private String boardModiDate;
	private int boardViewCnt;
	
}
