package com.inspur.exampleproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inspur.exampleproject.util.ReflectToStringUtil;


@Entity
@Table(name="DEMO_TEST")
public class DemoTest {
	
	@Id
	@Column(name = "DEMO_ID")
	private String demoId;
	
	@Column(name ="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="BIRTHDAY")
	private Date birthday;
	
	
	@Column(name="DEPT_ID")
	private String deptId;
	
	@Column(name="SEX")
	private String sex;
	
	
	@Column(name="HOBBY")
	private String hobby;
	
	@Column(name="REMARK")
	private String remark;

	public String getDemoId() {
		return demoId;
	}

	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	@Override
	public String toString() {
		return ReflectToStringUtil.toStringUtil(this,true);
	}
	
	

}
