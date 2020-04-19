package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Holiday {
	private String holidayCode;
	private String staffName;
	private String staffId;
	private String holidayFromDate;
	private String holidayToDate;
	private String holidaySort;
}
