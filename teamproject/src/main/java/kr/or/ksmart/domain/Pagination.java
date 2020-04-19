package kr.or.ksmart.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pagination<T> {
	private T list;
	private int startPage;
	private int currentPage;
	private int endPage;
	private int lastPage;
	
	public Pagination(int currentPage, int cnt) {
		this.currentPage = currentPage;
		this.startPage = currentPage - 5;
		if(this.startPage < 1) {
			this.startPage = 1;
		}
		this.endPage = currentPage + 5;
		this.lastPage = cnt/10 + 1;
		if(this.endPage > this.lastPage) {
			this.endPage = this.lastPage;
		}
	}
}
