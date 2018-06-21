package com.mymin.sort;

@SuppressWarnings("unchecked")
public class ShellSort {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] tag) {
		int len = tag.length;
		int h = 1;
		while (h < len / 3)
			h = h * 3 + 1;
		while (h >= 1) {
			for (int i = h; i < len; i++) {
				for (int j = i; j >= h && less(tag[j], tag[j - h]); j -= h) {
					exch(tag, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	@SuppressWarnings("rawtypes")
	public static boolean less(Comparable arg0, Comparable arg1) {
		return arg0.compareTo(arg1) < 0;
	}

	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] tag, int left, int right) {
		Comparable t = tag[left];
		tag[left] = tag[right];
		tag[right] = t;
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 6, 3, 7, 34, 45, 2, 34, 44, 45, 3, 12 };
		sort(a);
		for (Integer c : a) {
			System.out.println(":" + c);
		}
	}
}
