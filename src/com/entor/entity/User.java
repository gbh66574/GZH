package com.entor.entity;



import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;
import com.entor.entity1.IdUU;

public class User {
	private String id;
	private String username;
	private String password;
	private String name;
	private int sex;
	private String phone;
	private String address;
	private String email;
	private String photo;
	private String role;
	@JSONField(format="yyyy-MM-dd HH-mm-ss")
	private Timestamp createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", phone=" + phone + ", address=" + address + ", email=" + email + ", photo=" + photo
				+ ", role=" + role + ", createTime=" + createTime + "]";
	}
	public User(String id, String username, String password, String name, int sex, String phone, String address,
			String email, String photo, String role, Timestamp createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.photo = photo;
		this.role = role;
		this.createTime = createTime;
	}
	public User() {
		super();
	}
	
	
	
	
}
