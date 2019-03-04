package com.entor.entity;

import java.util.Date;

public class InfoContentCheck {
	private String id;
	private int pid;
	private String content;
	private int user_id;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "Info_Content_Check [id=" + id + ", pid=" + pid + ", content=" + content + ", user_id=" + user_id
				+ ", applyTime=" + applyTime + ", advise=" + advise + ", state=" + state + ", checkTime=" + checkTime
				+ "]";
	}
	public InfoContentCheck(String id, int pid, String content, int user_id, Date applyTime, String advise, int state,
			Date checkTime) {
		super();
		this.id = id;
		this.pid = pid;
		this.content = content;
		this.user_id = user_id;
		this.applyTime = applyTime;
		this.advise = advise;
		this.state = state;
		this.checkTime = checkTime;
	}
	public InfoContentCheck() {
		super();
	}
	
}
