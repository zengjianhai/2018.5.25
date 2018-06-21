package com.hibernate.pojo.one2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private Set<Order> orders = new HashSet<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Customer(long id, String name, Set<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", orders=" + orders + "]";
	}
	public Customer() {
	}
}
