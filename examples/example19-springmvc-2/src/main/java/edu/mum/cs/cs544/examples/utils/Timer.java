package edu.mum.cs.cs544.examples.utils;

/**
 * A very simple timer with 4 operations, start(), stop(), print() and getDuration()
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class Timer {
	private static long duration = 0;

	private static long startTime = -1;
	
	public static synchronized void start() {
		if(-1 != startTime) {
			// You can not restart a timer that has not been stopped
			throw new UnsupportedOperationException();
		}
		startTime = System.currentTimeMillis();
	}

	public static synchronized void stop() {
		if(-1 == startTime) {
			// You have to start the timer before you stop it
			throw new UnsupportedOperationException();
		}
		duration = System.currentTimeMillis() - startTime;
		startTime = -1; // reset timer
	}
	
	public static void print() {
		System.out.printf("Operation took %d milliseconds\n\n", getDuration());
	}
	
	public static long getDuration() {
		return duration;
	}
	
}
