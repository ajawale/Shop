package com.shop.model;

public class Address {
	
	private int number;
	private String postCode;
	
	
	
	public Address() {
		super();
	}
	public Address(int number, String postCode) {
		super();
		this.number = number;
		this.postCode = postCode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
	

}
