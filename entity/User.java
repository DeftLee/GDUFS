package com.gdufs.entity;

public class User {
	private String name;
	private String password;
	private String type;
	private String status;
	public User(String name,String password,String type,String status) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
