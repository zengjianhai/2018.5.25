package com.briup.mail;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware{
	private ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		context = arg0;
	}
	public void sendMail(String to) {
		System.out.println("MailSenderÄ£Äâ·¢ËÍÓÊ¼þ");
		MailSendEvent event = new MailSendEvent(this.context, to);
		context.publishEvent(event);
	}

}
