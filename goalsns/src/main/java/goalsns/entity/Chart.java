package goalsns.entity;

import java.util.Date;

public class Chart {
	private String mon;
	private int cnt;

	public Chart(String mon, int cnt) {
		super();
		this.mon = mon;
		this.cnt = cnt;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Chart() {};
	
}
