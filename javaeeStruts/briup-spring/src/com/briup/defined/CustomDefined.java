package com.briup.defined;

import java.beans.PropertyEditorSupport;
public class CustomDefined extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.indexOf(",") == -1) {
			throw new IllegalArgumentException("自定义的格式不符");
		}
		String[] vals = text.split(",");
		Car car = new Car();
		car.setName(vals[0]);
		System.out.println("---自定义---"+vals[0]);
		car.setLicense(vals[1]);
		car.setMade(vals[2]);
		this.setValue(car);
	}

}
