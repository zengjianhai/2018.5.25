package com.briup.java_bean.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MinTree implements Tree, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	private String treeName;

	public void setTreeName(String treeName) {
		System.out.println("-------注入属性值-------" + treeName);
		this.treeName = treeName;
	}

	public MinTree() {
		System.out.println("-----构造方法------" + treeName);
	}

	public void init() {
		setTreeName("我爱敏儿");
		System.out.println("自定义init");
	}

	@Override
	public void shape() {
		System.out.println("这颗" + treeName + "是小树");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("BeanNameAware接口的实现：" + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryAware接口：" + arg0.toString());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean接口");
	}

	public void destory() {
		System.out.println("自定义destory");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean接口");
	}
}
