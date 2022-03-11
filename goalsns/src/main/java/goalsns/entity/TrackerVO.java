package goalsns.entity;

public class TrackerVO {
	private String monthly;
	private String success;
	private int sysc_check;
	
	public TrackerVO() {};
	
	public TrackerVO(String monthly, String success, int sysc_check) {
		super();
		this.monthly = monthly;
		this.success = success;
		this.sysc_check = sysc_check;
	}
	public String getMonthly() {
		return monthly;
	}
	public void setMonthly(String monthly) {
		this.monthly = monthly;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public int getSysc_check() {
		return sysc_check;
	}
	public void setSysc_check(int sysc_check) {
		this.sysc_check = sysc_check;
	}
	
	
}
