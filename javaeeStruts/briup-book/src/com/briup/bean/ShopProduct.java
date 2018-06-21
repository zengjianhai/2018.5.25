package com.briup.bean;

public class ShopProduct {
	private Product product;
	private int amount;
	private User user;
	public ShopProduct() {
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ShopProduct(Product product, int amount, User user) {
		this.product = product;
		this.amount = amount;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ShopProduct [product=" + product + ", amount=" + amount + ", user=" + user + "]";
	}
}
