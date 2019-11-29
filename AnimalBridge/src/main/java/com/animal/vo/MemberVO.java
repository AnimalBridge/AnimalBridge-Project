package com.animal.vo;

public class MemberVO {
	private String email;
	private String name;
	private String nickName;
	private String password;
	private String phone;
	private String addr;
	private int centerIdx;
	
	
	public MemberVO() { }
	public MemberVO(String email,
					String name,
					String nickName,
					String password,
					String phone,
					String addr,
					int centerIdx) {
		this.email = email;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.addr = addr;
		this.centerIdx = centerIdx;
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
	
	
	public int getCenterIdx() {
		return centerIdx;
	}
	public void setCenterIdx(int centerIdx) {
		this.centerIdx = centerIdx;
	}
}
