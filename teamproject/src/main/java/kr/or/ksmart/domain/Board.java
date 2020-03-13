package kr.or.ksmart.domain;

public class Board {
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String staffName;
	private String boardWrtDate;
	private String boardModiDate;
	private int boardViewCnt;
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", staffName=" + staffName + ", boardWrtDate=" + boardWrtDate + ", boardModiDate=" + boardModiDate
				+ ", boardViewCnt=" + boardViewCnt + "]";
	}
	public int getBoardViewCnt() {
		return boardViewCnt;
	}
	public void setBoardViewCnt(int boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
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
