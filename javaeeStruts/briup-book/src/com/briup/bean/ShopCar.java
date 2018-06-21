package com.briup.bean;

public class ShopCar {
	private int id;
	private int count;
	private int user_id;
	public ShopCar() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public ShopCar(int id, int count, int user_id) {
		this.id = id;
		this.count = count;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", count=" + count + ", user_id=" + user_id + "]";
	}
}
