package com.smhrd.entity;

import java.time.LocalDate;

public class TrophyVO {
	private int cnt;
	private String color; //트로피컬러
	private int rate; //달성률
	
	public TrophyVO() {}

	public TrophyVO(int cnt, String color, int rate) {
		super();
		this.cnt = cnt;
		this.color = color;
		this.rate = rate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public void calcRate(int cnt) {
		LocalDate now = LocalDate.now();
		int today = now.getDayOfMonth();
		float rate = (cnt / (float)today) * 100;
		
		this.rate = (int)rate;
	}
	
	public void calcColor(int rate) {
		String color;
		if(rate < 20)
			color = "red";
		else if(rate < 40)
			color = "yellow";
		else if(rate < 70)
			color = "green";
		else if(rate < 90)
			color = "blue";
		else
			color = "rainbow";
		
		this.color = color;
	}
}
