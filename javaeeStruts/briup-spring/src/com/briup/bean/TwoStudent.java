package com.briup.bean;

import com.briup.impl.Pen;
import com.briup.impl.Student;

public class TwoStudent implements Student {
	private Pen pen;

	public TwoStudent() {
	}

	public TwoStudent(Pen pen) {
		this.pen = pen;
	}

	@Override
	public void usePen() {
		System.out.println("另一个学生："+pen.write());
	}

}
