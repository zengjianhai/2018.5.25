package com.briup.resource;

import org.springframework.core.io.Resource;

public class Two {
	private Resource resource;

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void parse() {
		System.out.println(resource.getFilename());
		System.out.println(resource.getDescription());
	}

}
