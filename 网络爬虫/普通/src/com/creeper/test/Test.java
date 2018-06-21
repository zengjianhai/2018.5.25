package com.creeper.test;


public class Test {
	private int len;
	static String val;

	public void method1() {
		System.out.println("---method1---");
		ChirlTest chirlTest = new ChirlTest();
		System.out.println(chirlTest.len);
		int a=0;
		class A{
			public void b(){
				System.out.println(a);
			}
		}
		new A().b();
	}

	class ChirlTest {
		int len;

		public void chirlMethod2() {
			System.out.println(Test.this.len);
			System.out.println(val);
			method1();
		}
	}

	static class ChirlTest2 {
		int len;

		public void chirlMethod2() {
			System.out.println(val);
		}
	}
}

class My {
	public static void main(String[] args) {
		Test test = new Test();
		test.method1();
	}
}