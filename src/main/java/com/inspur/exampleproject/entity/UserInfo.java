package com.inspur.exampleproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 用户信息
 * @author liyakun
 */
@Entity
@Table(name="USERINFO")
public class UserInfo {
	
	@Id
	@Column(name = "USERID")
	private String userId;
	
	@Column(name ="EMPID")
	private String empId;
	
	@Column(name="USERACCOUNT")
	private String userAccount;
	
	@Column(name="PASSWORD")
	private String passWord;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
