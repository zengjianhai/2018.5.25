package com.briup.bean;

import com.briup.impl.Pen;
import com.briup.impl.Student;

public class OneStudent implements Student{
	private Pen pen;
	public void setPen(Pen pen) {
		this.pen = pen;
	}
	@Override
	public void usePen() {
		System.out.println(pen.write());
	}
	
}
