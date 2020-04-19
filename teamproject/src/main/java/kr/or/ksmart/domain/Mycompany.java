package kr.or.ksmart.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Mycompany {
	private String mycompanyNumber; //등록번호
	private String mycompanyName;
	private String mycompanyPresident;
	private String mycompanyAddr;
	private String mycompanyTel;
	private String mycompanyFax;
}
