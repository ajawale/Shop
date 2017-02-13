package com.shop.model;

public class Shop {
	
	private String name;
	private Address address;
	private String latitude;
	private String longitude;
	
	
	
	public Shop() {
		super();
	}

	public Shop(String name, Address address, String latitude, String longitude) {
		super();
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return address;
	}
	public void setAddr(Address addr) {
		this.address = addr;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
		

}
