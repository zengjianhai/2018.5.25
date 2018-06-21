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
		System.out.println("-------ע������ֵ-------" + treeName);
		this.treeName = treeName;
	}

	public MinTree() {
		System.out.println("-----���췽��------" + treeName);
	}

	public void init() {
		setTreeName("�Ұ�����");
		System.out.println("�Զ���init");
	}

	@Override
	public void shape() {
		System.out.println("���" + treeName + "��С��");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("BeanNameAware�ӿڵ�ʵ�֣�" + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("BeanFactoryAware�ӿڣ�" + arg0.toString());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean�ӿ�");
	}

	public void destory() {
		System.out.println("�Զ���destory");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean�ӿ�");
	}
}
