package com.briup.exception;

public class MyThread extends Thread {
	static boolean f = false;

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {

		int i = 0;
		while (true) {
			if (f) {
				break;
			}
			if (Math.random() < 0.3 && getName().equals("兔子")) {
				i = i + 2;
				if (i >= 100)
					f = true;
				System.out.println(getName() + "跑了" + i + "米");
			} else if (Math.random() >= 0.3 && getName().equals("乌龟")) {
				i++;
				if (i >= 100)
					f = true;
				System.out.println(getName() + "跑了" + i + "米");
			}
		}

	}

	public static void main(String[] args) {
		MyThread myThread1 = new MyThread("兔子");
		MyThread myThread2 = new MyThread("乌龟");
		myThread1.start();
		myThread2.start();
	}
}
