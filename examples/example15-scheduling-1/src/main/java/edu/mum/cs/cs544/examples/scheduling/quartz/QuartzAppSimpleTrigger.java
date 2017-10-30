package edu.mum.cs.cs544.examples.scheduling.quartz;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;

public class QuartzAppSimpleTrigger {
	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		// define the job and tie it to our HelloJob class
		JobDetail job = newJob(HelloWorldJob.class)
				.withIdentity("HelloWorldJob", Scheduler.DEFAULT_GROUP)
				.build();
		
		// Trigger the job to run now, and then every 40 seconds
		Trigger trigger = newTrigger()
				.withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
				.startNow()
				.withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
		
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(job, trigger);
	}
}
