package com.mymin.sort;

@SuppressWarnings("unchecked")
public class ChanceSort {
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] tag) {
		int len = tag.length;
		for (int i = 0; i < len; i++) {
			int min=i;
			for (int j = i+1; j < len; j++) {
				if(less(tag[j], tag[min]))
					min=j;
				exch(tag, i, min);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean less(Comparable arg0,Comparable arg1){
		return arg0.compareTo(arg1)<0;
	}
	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] tag,int left,int right){
		Comparable t=tag[left];
		tag[left] = tag[right];
		tag[right] = t;
	}
	public static void main(String[] args) {
		Integer[] a={1,2,6,3,7,34,45,2};
		sort(a);
		for(Integer c:a){
			System.out.println(":"+c);
		}
	}
}
