package goalsns.entity;

import java.util.List;

public class RewardVO {
	private int chell_seq;
	private List<String> reward1;
	private List<TrackerVO> reward2;
	
	public RewardVO() {};
	
	public RewardVO(int chell_seq, List<String> reward1, List<TrackerVO> reward2) {
		super();
		this.chell_seq = chell_seq;
		this.reward1 = reward1;
		this.reward2 = reward2;
	}
	public int getChell_seq() {
		return chell_seq;
	}
	public void setChell_seq(int chell_seq) {
		this.chell_seq = chell_seq;
	}
	public List<String> getReward1() {
		return reward1;
	}
	public void setReward1(List<String> reward1) {
		this.reward1 = reward1;
	}
	public List<TrackerVO> getReward2() {
		return reward2;
	}
	public void setReward2(List<TrackerVO> reward2) {
		this.reward2 = reward2;
	}
	
	
}
