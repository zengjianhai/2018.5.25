package com.briup.struts;


import com.briup.struts.properties.OGNLProperties;


public class TestAction implements Action{
	private String tip;

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String execute() throws Exception {
		setTip(OGNLProperties.getValue());
		System.out.println("----执行到了第一个action----");
		return "to";
	}
}
