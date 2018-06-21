package com.hibernate.pojo.one2many;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String orderNumber;
	private Customer customer;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", customer=" + customer + "]";
	}
	public Order(String orderNumber, Customer customer) {
		this.orderNumber = orderNumber;
		this.customer = customer;
	}
	public Order() {
	}
}
