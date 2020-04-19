package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Outcome {
	private String branchName;
	private String staffName;
	private String year;
	private String month;
	private String sum;
}
