/**
 * 
 */
package com.sys.exam.database.model;

/**
 * @author Administrator
 *
 */
public class UserModel {
	private long userId;

    private String userName;

    private String userAccount;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
    
}
