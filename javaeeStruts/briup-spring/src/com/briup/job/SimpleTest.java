package com.briup.job;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTest {
	public static void main(String[] args) throws SchedulerException {
		JobDetail detail = new JobDetail("job1", "jgroup1", SimpleJob.class);
		SimpleTrigger trigger = new SimpleTrigger("trigger1","tgroup1");
		trigger.setStartTime(new Date());
		trigger.setRepeatInterval(200);
		trigger.setRepeatCount(10);
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(detail,trigger);
		scheduler.start();
	}
}
