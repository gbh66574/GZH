package com.entor.entity;

public class PublicNumberTemplate {
	private String id;
	private String pid;
	private String tid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "PublicNumberTemplate [id=" + id + ", pid=" + pid + ", tid=" + tid + "]";
	}
	public PublicNumberTemplate(String id, String pid, String tid) {
		super();
		this.id = id;
		this.pid = pid;
		this.tid = tid;
	}
	public PublicNumberTemplate() {
		super();
	}
	
	
}
