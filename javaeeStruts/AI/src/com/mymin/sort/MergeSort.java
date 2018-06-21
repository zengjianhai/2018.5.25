package com.mymin.sort;

@SuppressWarnings("unchecked")
public class MergeSort {
	@SuppressWarnings("rawtypes")
	static Comparable[] aum;

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] tag) {
		aum = new Comparable[tag.length];
		sort(tag, 0, tag.length - 1);
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] tag, int start, int end) {
		if (end <= start)
			return;
		int mid = start + (end - start) / 2;
		sort(tag, start, mid);
		sort(tag, mid + 1, end);
		merge(tag, start, mid, end);
	}
	@SuppressWarnings("rawtypes")
	public static void merge(Comparable[] tag, int start, int mid, int end) {
		int i = start, j = mid + 1;
		for (int k = start; k <= end; k++)
			aum[k] = tag[k];
		for (int k = start; k <= end; k++)
			if (i > mid)
				tag[k] = aum[j++];
			else if (j > end)
				tag[k] = aum[i++];
			else if (less(aum[j], aum[i]))
				tag[k] = aum[j++];
			else
				tag[k] = aum[i++];
	}

	@SuppressWarnings("rawtypes")
	public static boolean less(Comparable arg0, Comparable arg1) {
		return arg0.compareTo(arg1) < 0;
	}

	public static void main(String[] args) {
		Integer[] a = { 1, 2, 6, 3, 7, 34, 45, 2, 34, 44, 45, 3, 12 };
		sort(a);
		for (Integer c : a) {
			System.out.println(":" + c);
		}
	}
}
