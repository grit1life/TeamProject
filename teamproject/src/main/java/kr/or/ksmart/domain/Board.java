package kr.or.ksmart.domain;

public class Board {
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String staffCode;
	private String boardWrtDate;
	private String boardModiDate;
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", staffCode=" + staffCode + ", boardWrtDate=" + boardWrtDate + ", boardModiDate=" + boardModiDate
				+ "]";
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	public String getBoardWrtDate() {
		return boardWrtDate;
	}
	public void setBoardWrtDate(String boardWrtDate) {
		this.boardWrtDate = boardWrtDate;
	}
	public String getBoardModiDate() {
		return boardModiDate;
	}
	public void setBoardModiDate(String boardModiDate) {
		this.boardModiDate = boardModiDate;
	}
	
	
}
