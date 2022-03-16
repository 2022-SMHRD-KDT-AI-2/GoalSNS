package com.smhrd.entity;

public class ChellVO {
	private int chell_seq;
	private String chell_name;
	
	public ChellVO() {};

	public ChellVO(int chell_seq, String chell_name) {
		super();
		this.chell_seq = chell_seq;
		this.chell_name = chell_name;
	}
	public int getChell_seq() {
		return chell_seq;
	}
	public void setChell_seq(int chell_seq) {
		this.chell_seq = chell_seq;
	}
	public String getChell_name() {
		return chell_name;
	}
	public void setChell_name(String chell_name) {
		this.chell_name = chell_name;
	}

	
}
