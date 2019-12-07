package com.sc.bean;

public class UsersBean {

	private Integer uid;
	private String uname;
	private String upass;
	
	public UsersBean(String uname, String upass) {
		super();
		this.uname = uname;
		this.upass = upass;
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	
}
