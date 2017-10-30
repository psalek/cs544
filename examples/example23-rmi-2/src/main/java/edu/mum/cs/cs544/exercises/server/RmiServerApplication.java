package edu.mum.cs.cs544.exercises.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RmiServerApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfigserver.xml");
		System.out.println("The HelloServer is running...");
	}
}
