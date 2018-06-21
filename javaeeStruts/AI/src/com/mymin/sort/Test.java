package com.mymin.sort;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int a[] = { 1, 5 };
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < a.length; j++) {
				if (list.get(i) == a[j]) {
					list.remove(i);
					break;
				}
			}
		}
		System.out.println(list);

		String string = "absdsdsds";
		String strCopy = "ojsjddhabs";
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < strCopy.length(); j++) {
				if (string.charAt(i) == strCopy.charAt(j)) {
					System.out.println(j);
					count++;          //如果连续相等就会叠加，计算长度
					break;
				}else{
					count = 0;       //中间出现断了，就重新计算
				}
			}
		}
	}
}
