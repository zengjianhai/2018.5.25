package com.mymin.sort;

import java.util.Arrays;

public class BinarySearch {
	public static int rank(int key, int[] tag) {
		int start = 0;
		int end = tag.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (key < tag[mid])
				end = mid - 1;
			else if (key > tag[mid])
				start = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] tag = { 1, 3, 4, 2, 6, 8, 5 };
		Arrays.sort(tag);
		int value = rank(8, tag);
		if (value == -1) {
			System.out.println("不存在");
		}else{
			System.out.println("在位置"+(value+1)+"找到");
		}
	}
}
