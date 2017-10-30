package edu.mum.cs.cs544.examples.async.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		SampleClass sc = context.getBean("sampleClass", SampleClass.class);
		sc.longRunningMethod();
		System.out.println("Main method continues on!");
	}
}