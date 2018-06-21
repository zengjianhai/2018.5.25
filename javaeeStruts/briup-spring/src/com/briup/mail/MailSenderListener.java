package com.briup.mail;

import org.springframework.context.ApplicationListener;

public class MailSenderListener implements ApplicationListener<MailSendEvent>{

	@Override
	public void onApplicationEvent(MailSendEvent arg0) {
		MailSendEvent event = (MailSendEvent)arg0;
		System.out.println("MailSenderListener:��"+event.getTo()+"�����ʼ�");
	}

}
