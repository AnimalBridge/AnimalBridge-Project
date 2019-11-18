package com.animal.vo;

public class MapVO {
	private String email;
	private String x; 
	private String y ;
	private String special;
	private String title;
	private String map_address;
	
	public MapVO() {}
	
	public MapVO(String email, String x, String y, String special, String title, String map_address) {
		this.email = email;
		this.x = x;
		this.y = y;
		this.special = special;
		this.title = title;
		this.map_address = map_address;
				
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMap_address() {
		return map_address;
	}

	public void setMap_address(String map_address) {
		this.map_address = map_address;
	}

	@Override
	public String toString() {
		return "MapVO [email=" + email + ", x=" + x + ", y=" + y + ", "
				+ "special=" + special + ", title=" + title
				+ ", map_address=" + map_address + "]";
	}
	
	
}
