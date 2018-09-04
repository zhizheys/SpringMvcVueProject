package com.me.entity;

import java.util.Date;

public class User {
	private Integer userId;
	private String userName;
    private int userAge;
    private String userAddress;
    private String userPassword;
    private Date userBirthday;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Date getUserBirthday() {
		return userBirthday;
	}
	
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String toString(){
		return "User [id=" + userId + ", name=" + userName ;
	}

}