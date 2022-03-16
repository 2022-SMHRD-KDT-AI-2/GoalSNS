package com.smhrd.entity;

public class LikeCheckVO {
	private int pseq;
	private int lseq;
	
	public LikeCheckVO() {};
	
	public LikeCheckVO(int pseq, int lseq) {
		super();
		this.pseq = pseq;
		this.lseq = lseq;
	}
	public int getPseq() {
		return pseq;
	}
	public void setPseq(int pseq) {
		this.pseq = pseq;
	}
	public int getLseq() {
		return lseq;
	}
	public void setLseq(int lseq) {
		this.lseq = lseq;
	}
	
	
}
