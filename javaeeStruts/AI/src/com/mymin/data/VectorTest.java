package com.mymin.data;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>(5, 2);
		System.out.println("vector size:"+vector.size());
		System.out.println("vector capacity:"+vector.capacity());
		vector.addElement(1);
		vector.addElement(1);
		vector.addElement(1);
		vector.addElement(1);
		vector.addElement(1);
		vector.addElement(3);
		System.out.println("vector capacity:"+vector.capacity());
		System.out.println("vector first:"+vector.firstElement());
		System.out.println("vector last:"+vector.lastElement());
		Enumeration<Integer> es = vector.elements();
		while (es.hasMoreElements()) {
			Integer integer = (Integer) es.nextElement();
			System.out.println(integer);
		}
	}
}
