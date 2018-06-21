package com.briup.defined;

public class Car {
	private String name;
	private String license;
	private String made;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", license=" + license + ", made=" + made + "]";
	}
}
