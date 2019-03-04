package com.entor.entity;

public class UserPublicNumber {
	private String id;
	private String user_id;
	private String pid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "User_Public_Number [id=" + id + ", user_id=" + user_id + ", pid=" + pid + "]";
	}
	public UserPublicNumber(String id, String user_id, String pid) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.pid = pid;
	}
	public UserPublicNumber() {
		super();
	}
	
}
