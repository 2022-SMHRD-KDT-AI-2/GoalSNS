package com.smhrd.entity;

public class TrendVO {
	private String chell_name;
	private int cnt;
	private int chell_seq;
	
	public TrendVO() {};
	
	public TrendVO(String chell_name, int cnt, int chell_seq) {
		super();
		this.chell_name = chell_name;
		this.cnt = cnt;
		this.chell_seq = chell_seq;
	}
	public String getChell_name() {
		return chell_name;
	}
	public void setChell_name(String chell_name) {
		this.chell_name = chell_name;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getChell_seq() {
		return chell_seq;
	}
	public void setChell_seq(int chell_seq) {
		this.chell_seq = chell_seq;
	}
	
	
}
