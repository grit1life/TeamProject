package kr.or.ksmart.domain;

public class Board {
	private String no;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private String modifyingDate;
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", writeDate="
				+ writeDate + ", modifyingDate=" + modifyingDate + "]";
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getModifyingDate() {
		return modifyingDate;
	}
	public void setModifyingDate(String modifyingDate) {
		this.modifyingDate = modifyingDate;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
