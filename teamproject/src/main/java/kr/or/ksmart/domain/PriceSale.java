package kr.or.ksmart.domain;

public class PriceSale {

	private int periodMax;
	private int periodMin;
	private double rateMax;
	private double rateMin;
	public int getPeriodMax() {
		return periodMax;
	}
	public void setPeriodMax(int periodMax) {
		this.periodMax = periodMax;
	}
	public int getPeriodMin() {
		return periodMin;
	}
	public void setPeriodMin(int periodMin) {
		this.periodMin = periodMin;
	}
	public double getRateMax() {
		return rateMax;
	}
	public void setRateMax(double rateMax) {
		this.rateMax = rateMax;
	}
	public double getRateMin() {
		return rateMin;
	}
	public void setRateMin(double rateMin) {
		this.rateMin = rateMin;
	}
}
