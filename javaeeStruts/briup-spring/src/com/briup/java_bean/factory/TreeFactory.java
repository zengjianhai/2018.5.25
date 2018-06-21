package com.briup.java_bean.factory;

public class TreeFactory {
	public Tree getTree(String tree) {
		System.out.println(tree);
		if (tree.equalsIgnoreCase("maxTree")) {
			System.out.println("--½øÈë--");
			return new MaxTree();
		} else {
			return new MinTree();
		}
	}
}
