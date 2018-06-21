package com.briup.resource;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class TestBean implements ResourceLoaderAware{
	private ResourceLoader re;
	@Override
	public void setResourceLoader(ResourceLoader re) {
		this.re = re;
	}
	public ResourceLoader getResourceLoader(){
		return re;
	}
	
}
