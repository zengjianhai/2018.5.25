package com.mymin.data;

public class Stack {
	public static void main(String[] args) {
		java.util.Stack<Integer> stack = new java.util.Stack<>();
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
}
