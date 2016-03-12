package com.edot.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user_info")
public class UserInfoModel extends BaseModel {

	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private int gender;
	@Column(name = "salary")
	private int salary;
	@Column(name = "email")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
