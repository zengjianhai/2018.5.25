package com.mymin.sort;

@SuppressWarnings("unchecked")
public class Insertion {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] tag) {
		int count=0;
		int len = tag.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0 && less(tag[j], tag[j - 1]); j--) {
				exch(tag, j, j - 1);
				count++;
			}
		}
		System.out.println("count:"+count);
	}
	@SuppressWarnings("rawtypes")
	public static void sortCopy(Comparable[] tag) {
		int count=0;
		int j;
		int len = tag.length;
		for (int i = 1; i < len; i++) {
			Comparable tmp = tag[i];
			Comparable current = null;
			for (j = i; j > 0 && tmp.compareTo((current=tag[j-1])) < 0; j--) {
				tag[j] = current;
				count++;
			}
			tag[j] = tmp;
		}
		System.out.println("count:"+count);
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
		Integer[] a = { 1, 2, 6, 3, 7, 34, 45, 2 ,34,44,45,3,12};
		sortCopy(a);
		for (Integer c : a) {
			System.out.println(":" + c);
		}
	}
}
