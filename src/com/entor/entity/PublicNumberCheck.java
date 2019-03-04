package com.entor.entity;

import java.util.Date;

public class PublicNumberCheck {
	private String id;
	private int user_id;
	private int pid;
	private Date applyTime;
	private String advise;
	private int state;
	private Date checkTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getAdvise() {
		return advise;
	}
	public void setAdvise(String advise) {
		this.advise = advise;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	@Override
	public String toString() {
		return "User_Public_Number [id=" + id + ", user_id=" + user_id + ", pid=" + pid + ", applyTime=" + applyTime
				+ ", advise=" + advise + ", state=" + state + ", checkTime=" + checkTime + "]";
	}
	public PublicNumberCheck(String id, int user_id, int pid, Date applyTime, String advise, int state,
			Date checkTime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pid = pid;
		this.applyTime = applyTime;
		this.advise = advise;
		this.state = state;
		this.checkTime = checkTime;
	}
	public PublicNumberCheck() {
		super();
	}
	
}
