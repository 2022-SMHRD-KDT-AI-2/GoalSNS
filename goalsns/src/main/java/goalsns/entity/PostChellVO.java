package goalsns.entity;

public class PostChellVO {
	private int post_seq;
	private int chell_seq;
	private int mapping_seq;
	public PostChellVO() {};
	public PostChellVO(int post_seq, int chell_seq, int mapping_seq) {
		super();
		this.post_seq = post_seq;
		this.chell_seq = chell_seq;
		this.mapping_seq = mapping_seq;
	}
	public int getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(int post_seq) {
		this.post_seq = post_seq;
	}
	public int getChell_seq() {
		return chell_seq;
	}
	public void setChell_seq(int chell_seq) {
		this.chell_seq = chell_seq;
	}
	public int getMapping_seq() {
		return mapping_seq;
	}
	public void setMapping_seq(int mapping_seq) {
		this.mapping_seq = mapping_seq;
	}
	
}
