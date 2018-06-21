package com.briup.java_bean.factory;

public class MaxTree implements Tree{
	private String treeName;
	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	public MaxTree() {
		System.out.println("--------max构造方法---------");
	}
	@Override
	public void shape() {
		System.out.println("这颗"+treeName+"是大树");
	}
}
