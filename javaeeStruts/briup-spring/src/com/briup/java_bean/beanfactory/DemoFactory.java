package com.briup.java_bean.beanfactory;

import org.springframework.beans.factory.FactoryBean;

public class DemoFactory implements FactoryBean<News>{
	private News newDemo;
	@Override
	public News getObject() throws Exception {
		if(newDemo==null){
			newDemo = new News();
		}
		System.out.println("---getObject-----"+newDemo);
		return newDemo;
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("---getObjectType-----"+getClass());
		return News.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("---isSingleton-----");
		return true;
	}

}
