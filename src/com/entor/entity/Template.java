package com.entor.entity;

import java.security.Timestamp;


public class Template {
	private String id;
	private String name;
	private String content;
	private String type;
	private String remark;
	private int user_id;
	private Timestamp createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
		return "Template [id=" + id + ", name=" + name + ", content=" + content + ", type=" + type + ", remark="
				+ remark + ", user_id=" + user_id + ", createTime=" + createTime + "]";
	}
	public Template(String id, String name, String content, String type, String remark, int user_id,
			Timestamp createTime) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.type = type;
		this.remark = remark;
		this.user_id = user_id;
		this.createTime = createTime;
	}
	public Template() {
		super();
	}
	
}
