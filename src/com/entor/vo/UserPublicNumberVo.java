package com.entor.vo;

public class UserPublicNumberVo {
	private String id;
	private String public_name;
	private String username;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserPublicNumberVo [id=" + id + ", public_name=" + public_name + ", username=" + username + "]";
	}
	public UserPublicNumberVo(String id, String public_name, String username) {
		super();
		this.id = id;
		this.public_name = public_name;
		this.username = username;
	}
	public UserPublicNumberVo() {
		super();
	}
	
}
