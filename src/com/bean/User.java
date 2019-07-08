package com.bean;

public class User {
	private String userID; //身份证号
	private String password;
	private String phone; //手机
	private String email; //邮箱
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String userID, String password, String phone, String email) {
		super();
		this.userID = userID;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
