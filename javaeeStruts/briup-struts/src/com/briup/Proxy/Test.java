package com.briup.Proxy;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory = new ProxyFactory();
		ProductService proxy=(ProductService)factory.getProxy(ProductService.class);
		proxy.addProduct();
		proxy.deleteProduct();
	}
}
