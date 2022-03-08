package goalsns.entity;

public class LikeVO {
	
	private int like_seq;
	private int post_seq;
	private String mem_id;
	
	public int getLike_seq() {
		return like_seq;
	}
	public void setLike_seq(int like_seq) {
		this.like_seq = like_seq;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
}
