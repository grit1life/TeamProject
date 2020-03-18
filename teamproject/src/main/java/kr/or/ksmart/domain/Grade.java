package kr.or.ksmart.domain;

public class Grade {
	private String customerClass;
	private int gradeCnt;
	public String getCustomerClass() {
		return customerClass;
	}
	public void setCustomerClass(String customerClass) {
		this.customerClass = customerClass;
	}
	public int getGradeCnt() {
		return gradeCnt;
	}
	public void setGradeCnt(int gradeCnt) {
		this.gradeCnt = gradeCnt;
	}
	@Override
	public String toString() {
		return "Grade [customerClass=" + customerClass + ", gradeCnt=" + gradeCnt + "]";
	}
}
