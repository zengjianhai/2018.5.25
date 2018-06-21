package com.briup.test.struts;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

public class MyDecider implements Decider{

	@Override
	public boolean decide(Object arg0) throws Exception {
		String value = (String)arg0;
		return value.indexOf("j")>=0;
	}

}
