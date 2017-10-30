package edu.mum.cs.cs544.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSReceiverApp {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigreceiver.xml");
		System.out.println("JMS receiver is running ...");
	}

}
