package edu.mum.cs.cs544.examples.scheduling.quartz;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloWorldJob implements Job {
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Date date = Calendar.getInstance().getTime();
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		String currenttime = timeFormatter.format(date);
		System.out.println("This task ran at " + currenttime);
	}
}
