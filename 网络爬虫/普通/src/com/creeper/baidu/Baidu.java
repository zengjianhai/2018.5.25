package com.creeper.baidu;


public class Baidu {
	public static void main(String[] args) {
		String val = Factory.getReaderHtml("http://www.baidu.com", "utf-8",new ConnFactory());
		System.out.println(val);
	}
}
