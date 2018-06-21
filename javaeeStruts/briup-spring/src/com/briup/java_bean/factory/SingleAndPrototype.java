package com.briup.java_bean.factory;

public abstract class SingleAndPrototype {

	public SingleAndPrototype() {
		System.out.println("SingleAndPrototype¹¹ÔìÆ÷");
	}
	public abstract MaxTree getMaxTree();
	public void into(){
		getMaxTree().shape();
	}
}
