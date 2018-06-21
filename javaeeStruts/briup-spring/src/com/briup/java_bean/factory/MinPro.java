package com.briup.java_bean.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MinPro implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		if (arg0 instanceof MinTree) {
			MinTree user = (MinTree) arg0;
			user.setTreeName("�����ĵڶ���������");
			return user;
		}
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		if (arg0 instanceof MinTree) {
			MinTree user = (MinTree) arg0;
			user.setTreeName("�����ĵ�һ��������");
			return user;
		}
		return arg0;
	}

}
