package com.briup.exception;


public class Test {
	public static void main(String[] args) {
		String string = "A想sdab";
		System.out.println(string.compareTo("asdaa"));
		System.out.println(string.concat("ab"));
		//除a外的都替换为a
		System.out.println(string.replaceAll("[^a]", "a"));
		//截取字符串的0-2的字符
		System.out.println(string.substring(0, 2));
		//在指定引索是否以d开始
		System.out.println(string.startsWith("d",2));
		//判定是否以asd开始
		System.out.println(string.startsWith("asd"));
		//忽略字符串前后空格
		System.out.println("             asd as".trim());
		//split分割
		String str[] = string.split("a");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		//把字符串转换成char字符数组
		char[] cs = string.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			System.out.println(cs[i]);
		}
		//把字符串的字母转成小写
		System.out.println(string.toLowerCase());
		System.out.println(string.toUpperCase());
		System.out.println(string.matches("a"));
		try {
			throw new MyException("我的异常");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
