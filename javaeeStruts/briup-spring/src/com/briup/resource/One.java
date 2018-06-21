package com.briup.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class One {
	public static void main(String[] args) throws Exception{
		UrlResource uResource = new UrlResource("file:book.xml");
		System.out.println(uResource.getFilename());
		System.out.println(uResource.getDescription());
		ClassPathResource cpr = new ClassPathResource("book.xml");
		System.out.println(cpr.getFilename());
		System.out.println(cpr.getDescription());
		ApplicationContext aContext = new ClassPathXmlApplicationContext("factory.xml");
		Resource resource = aContext.getResource("book.xml");
		System.out.println(resource.getFilename());
		System.out.println(resource.getDescription());
	}
}
