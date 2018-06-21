package com.briup.job;

import java.text.ParseException;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class CronTest {
	public static void main(String[] args) throws SchedulerException, ParseException {
		JobDetail detail = new JobDetail("job1", "jgroup1", SimpleJob.class);
		CronTrigger trigger = new CronTrigger("trigger1","tgroup1");
		CronExpression expression = new CronExpression("0/1 * 16 * * ?");
		trigger.setCronExpression(expression);
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler scheduler = factory.getScheduler();
		scheduler.scheduleJob(detail,trigger);
		scheduler.start();
	}
}
