package edu.mum.cs.cs544.examples.scheduling.spring;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class MyClass {
	@Scheduled(fixedRate = 5000, initialDelay = 1000)
	public void fixedRateMethod() {
		System.out.println(getFormattedTime() + " - Fixed rate");
	}

	@Scheduled(fixedDelay = 5000, initialDelay = 2000)
	public void fixedDelayMethod() {
		System.out.println(getFormattedTime() + " - Fixed delay");
	}

	@Scheduled(cron = "0/5 * * * * *")
	public void cronMethod() {
		System.out.println(getFormattedTime() + " - Cron expression");
	}
	
	private String getFormattedTime() {
		Date date = Calendar.getInstance().getTime();
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		return timeFormatter.format(date);
	}
}