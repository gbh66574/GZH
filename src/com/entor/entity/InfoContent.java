package com.entor.entity;

import java.sql.Timestamp;

public class InfoContent {
	private String id;
	private int address;
	private String content;
	private int tid;
	private int user_id;
	private Timestamp createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Info_Content [id=" + id + ", address=" + address + ", content=" + content + ", tid=" + tid
				+ ", user_id=" + user_id + ", createTime=" + createTime + "]";
	}
	public InfoContent(String id, int address, String content, int tid, int user_id, Timestamp createTime) {
		super();
		this.id = id;
		this.address = address;
		this.content = content;
		this.tid = tid;
		this.user_id = user_id;
		this.createTime = createTime;
	}
	public InfoContent() {
		super();
	}
	
}
