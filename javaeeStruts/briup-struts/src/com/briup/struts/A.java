package com.briup.struts;

public class A {
	public static void main(String[] args) {
//		short i=1;
//		i=(short)(i+1);
//		throw new RuntimeException("抛出你妹");
		LinkCon<Integer ,Object> con = new LinkCon<Integer ,Object>();
		con.add(1,new Link("呵呵", "哈哈"));
		con.add(2,"爱你");
		System.out.println(con.get(1));
		System.out.println(con.get(2));
		con.set(2,new Link("嘿嘿", "爱你"));
		System.out.println(con.get(1));
		System.out.println(con.get(2));
	}
}
