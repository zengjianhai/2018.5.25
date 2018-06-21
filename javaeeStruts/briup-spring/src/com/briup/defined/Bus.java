package com.briup.defined;

public class Bus {
	private Car car;
	private String name;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Bus [car=" + car + ", name=" + name + "]";
	}
}
