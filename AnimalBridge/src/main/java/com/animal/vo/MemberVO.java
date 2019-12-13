package com.animal.vo;

public class MemberVO {
	private String email;
	private String name;
	private String nickName;
	private String password;
	private String phone;
	private String addr;
	private String edu_state;
	private int no_show_cnt;
	private int center_idx;
	
	public MemberVO() { }
	public MemberVO(String email,
					String name,
					String nickName,
					String password,
					String phone,
					String addr) {
		this.email = email;
		this.name = name;
		this.nickName = nickName;
		this.password = password;
		this.phone = phone;
		this.addr = addr;
		this.edu_state = "no";
		this.no_show_cnt = 0;
		this.center_idx = 0;
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
	public String getEdu_state() {
		return edu_state;
	}
	public void setEdu_state(String edu_state) {
		this.edu_state = edu_state;
	}
	public int getNo_show_cnt() {
		return no_show_cnt;
	}
	public void setNo_show_cnt(int no_show_cnt) {
		this.no_show_cnt = no_show_cnt;
	}
	public int getCenter_idx() {
		return center_idx;
	}
	public void setCenter_idx(int center_idx) {
		this.center_idx = center_idx;
	}
	
	
}
