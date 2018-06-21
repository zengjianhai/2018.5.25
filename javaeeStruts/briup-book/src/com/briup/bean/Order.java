package com.briup.bean;

public class Order {
	private int id;
	private int product_id;
	private int amount;
	private int user_id;
	private int consignee_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getConsignee_id() {
		return consignee_id;
	}
	public void setConsignee_id(int consignee_id) {
		this.consignee_id = consignee_id;
	}
	public Order() {
	}
	public Order(int id, int product_id, int amount, int user_id, int consignee_id) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.amount = amount;
		this.user_id = user_id;
		this.consignee_id = consignee_id;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", product_id=" + product_id + ", amount=" + amount + ", user_id=" + user_id
				+ ", consignee_id=" + consignee_id + "]";
	}
}
