package edu.mum.cs.cs544.examples.scheduling.quartz;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

public class QuartzAppCronTrigger {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();

		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloWorldJob.class).withIdentity("HelloWorldJob", Scheduler.DEFAULT_GROUP).build();

		// Trigger the job to run now, and then every 40 seconds
		Trigger trigger = newTrigger()
				.withIdentity("trigger3", "group1")
				.withSchedule(cronSchedule("0/5 * * * * ?"))
				.build();

		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
	}
}
