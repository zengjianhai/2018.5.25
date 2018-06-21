package com.briup.bean;

public class User {
	private String name; 
	private String pass; 
	private String address;
	private String phone; 
	private String email; 
	private String postcode;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public User() {
	}
	public User(String name, String pass, String address, String phone, String email, String postcode) {
		this.name = name;
		this.pass = pass;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.postcode = postcode;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", postcode=" + postcode + "]";
	}
}
