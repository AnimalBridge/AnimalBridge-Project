package com.animal.vo;

public class MemberVO {
	private String email;
	private String name;
	private String nickName;
	private String password;
	private String phone;
	private String addr;
	private String grade;
	
	
	public MemberVO() { }
	public MemberVO(String email,
					String name,
					String nickName,
					String password,
					String phone,
					String addr,
					String grade) {
		this.email = email;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.addr = addr;
		this.grade = grade;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
