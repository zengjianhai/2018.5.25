package com.mymin.sort;

public class Sort {
	private static char[] charStr = { '1', '2' };

	public static void main(String[] args) {
		perm(charStr, 0, charStr.length - 1);
	}

	public static void perm(char[] buf, int start, int end) {
		if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可（特殊情况）
			for (int i = 0; i <= end; i++) {
				System.out.print(buf[i]);
			}
			System.out.println();
		} else {// 多个字母全排列（普遍情况）
			for (int i = start; i <= end; i++) {// （让指针start分别指向每一个数）
				char temp = buf[start];// 交换数组第一个元素与后续的元素
				buf[start] = buf[i];
				buf[i] = temp;
				
				perm(buf, start + 1, end);// 后续元素递归全排列
				
				temp = buf[start];// 将交换后的数组还原
				buf[start] = buf[i];
				buf[i] = temp;
			}
		}
	}
}
