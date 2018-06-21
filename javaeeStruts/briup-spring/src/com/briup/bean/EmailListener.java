package com.briup.bean;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class EmailListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		if (arg0 instanceof EmailEvent) {
			EmailEvent emailEvent = (EmailEvent)arg0;
			System.out.println("address:"+emailEvent.getAddress());
			System.out.println("text:"+emailEvent.getText());
		} else {
			System.out.println("spring容器本身事件:"+arg0);
		}
	}

}
