package com.briup.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/briup/mail/mail.xml");
		MailSender sender = (MailSender)context.getBean("mail");
		sender.sendMail("2506606492@qq.com");
	}
}
