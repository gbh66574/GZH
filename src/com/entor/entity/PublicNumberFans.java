package com.entor.entity;

import java.util.Date;

public class PublicNumberFans {
	private String id;
	private int pid;
	private int addFans;
	private int reduceFans;
	private Date countTime;
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
	public int getAddFans() {
		return addFans;
	}
	public void setAddFans(int addFans) {
		this.addFans = addFans;
	}
	public int getReduceFans() {
		return reduceFans;
	}
	public void setReduceFans(int reduceFans) {
		this.reduceFans = reduceFans;
	}
	public Date getCountTime() {
		return countTime;
	}
	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}
	@Override
	public String toString() {
		return "Public_Number_Fans [id=" + id + ", pid=" + pid + ", addFans=" + addFans + ", reduceFans=" + reduceFans
				+ ", countTime=" + countTime + "]";
	}
	public PublicNumberFans(String id, int pid, int addFans, int reduceFans, Date countTime) {
		super();
		this.id = id;
		this.pid = pid;
		this.addFans = addFans;
		this.reduceFans = reduceFans;
		this.countTime = countTime;
	}
	public PublicNumberFans() {
		super();
	}
	
}
