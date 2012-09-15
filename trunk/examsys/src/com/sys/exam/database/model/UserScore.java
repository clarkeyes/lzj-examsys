package com.sys.exam.database.model;

public class UserScore {
	private Long ueId;
	private String userAccount;
	private String userName;
	private String ueState;
	private Float ueGrade;
	public Long getUeId() {
		return ueId;
	}
	public void setUeId(Long ueId) {
		this.ueId = ueId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUeState() {
		return ueState;
	}
	public void setUeState(String ueState) {
		this.ueState = ueState;
	}
	public Float getUeGrade() {
		return ueGrade;
	}
	public void setUeGrade(Float ueGrade) {
		this.ueGrade = ueGrade;
	}
	
}
