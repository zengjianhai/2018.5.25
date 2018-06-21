package com.briup.db;


public class Test {
	public static void main(String[] args) {
		String sql = SQLCreateFactory.getCreate("com.briup.db.User");
		System.out.println(sql);
	}
}
