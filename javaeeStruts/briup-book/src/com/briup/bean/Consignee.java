package com.briup.bean;

public class Consignee {
	private int id;
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	private String name;
	private String phone;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Consignee() {
	}
	public Consignee(int id, String name, String phone, String address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Consignee(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Consignee(String name, String phone, String address,int user_id) {
		this.user_id = user_id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Consignee [id=" + id + ", user_id=" + user_id + ", name=" + name + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
}
