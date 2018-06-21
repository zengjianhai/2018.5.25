package com.briup.Proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//1.产生代理对象 2.书写回调函数
public class ProxyFactory implements MethodInterceptor {

	// 产生代理对象
	public Object getProxy(Class c) {
		Enhancer enhancer = new Enhancer();
		// 把目标设置成父类
		enhancer.setSuperclass(c);
		// 设置回调
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}
	// arg0代表目标对象，arg1代表方法
	// arg2方法的参数，arg3方法的镜像

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("before");
		Object obj = arg3.invokeSuper(arg0, arg2);
		System.out.println("after");
		return obj;
	}

}
