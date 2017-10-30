package edu.mum.cs.cs544.examples.scheduling.spring;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloWorldPojo {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void welcome() {
		Date date = Calendar.getInstance().getTime();
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		String currenttime = timeFormatter.format(date);
		System.out.println("This task runs at " + currenttime + " message= " + message);
	}
}