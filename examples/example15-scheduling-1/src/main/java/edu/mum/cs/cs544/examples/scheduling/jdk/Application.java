package edu.mum.cs.cs544.examples.scheduling.jdk;

import java.util.Timer;

public class Application {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new HelloWorldTask(), 5000, 5000);
	}
}
