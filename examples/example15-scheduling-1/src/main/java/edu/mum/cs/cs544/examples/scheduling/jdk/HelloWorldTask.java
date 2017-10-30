package edu.mum.cs.cs544.examples.scheduling.jdk;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class HelloWorldTask extends TimerTask {
	public void run() {
		Date date = Calendar.getInstance().getTime();
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
		String currenttime = timeFormatter.format(date);
		System.out.println("This task ran at " + currenttime);
	}
}
