package edu.mum.cs.cs544.examples.async.spring;

import org.springframework.scheduling.annotation.Async;

public class SampleClass {
	@Async
	public void longRunningMethod() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished longRunningMethod");
	}
}