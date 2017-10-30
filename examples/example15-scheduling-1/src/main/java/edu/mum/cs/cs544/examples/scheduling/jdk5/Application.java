package edu.mum.cs.cs544.examples.scheduling.jdk5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService tpool = Executors.newScheduledThreadPool(5);
		HelloWorldTask task = new HelloWorldTask();
		
		// executes 5 seconds after being called (does not repeat)
		tpool.schedule(task, 5, TimeUnit.SECONDS);
		
		// executes 1 second after being called
		// repeats exactly 5 seconds after first call
		tpool.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);
		
		// executes 1 second after being called
		// repeats 5 after the last one finished
		tpool.scheduleWithFixedDelay(task, 1, 5, TimeUnit.SECONDS);
		
		// close the schedule thread pool (stops all scheduled tasks) after one minute
		Thread.sleep(60000);
		tpool.shutdown();
	}
}
