package com.smhrd.entity;

import java.util.Date;

public class PostVO {
	private int post_seq;
	private String post_content;
	private String post_file;
	private Date post_date;
	private String mem_id;
	private int chell_seq;
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public String getPost_file() {
		return post_file;
	}
	public void setPost_file(String post_file) {
		this.post_file = post_file;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getChell_seq() {
		return chell_seq;
	}
	public void setChell_seq(int chell_seq) {
		this.chell_seq = chell_seq;
	}
	
	
}
