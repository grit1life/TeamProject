package kr.or.ksmart.domain;

public class Outcome {
	private String month;
	private String sum;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Outcome [month=" + month + ", sum=" + sum + "]";
	}
}
