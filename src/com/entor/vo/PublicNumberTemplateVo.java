package com.entor.vo;

public class PublicNumberTemplateVo {
	private String id;
	private String public_name;
	private String tname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPublic_name() {
		return public_name;
	}
	public void setPublic_name(String public_name) {
		this.public_name = public_name;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "PublicNumberTemplateVo [id=" + id + ", public_name=" + public_name + ", tname=" + tname + "]";
	}
	public PublicNumberTemplateVo(String id, String public_name, String tname) {
		super();
		this.id = id;
		this.public_name = public_name;
		this.tname = tname;
	}
	public PublicNumberTemplateVo() {
		super();
	}
	
}
