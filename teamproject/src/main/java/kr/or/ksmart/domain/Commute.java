package kr.or.ksmart.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Commute {
	private String staffName;
	private String commuteDate;
	private String commuteArrive;
	private String commuteLeave;
	private String commuteLateness;
	private String commuteEarlyleave;
	private String holidaySort;
}
