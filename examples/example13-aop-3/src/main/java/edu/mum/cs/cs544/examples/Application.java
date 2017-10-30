package edu.mum.cs.cs544.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

		AccountService accountService = context.getBean("accountService", AccountService.class);
		
		try{
			accountService.deposit(1234L, 2000);	
			accountService.deposit(4321L, 1000);
		} catch(Exception e) {
			// Do nothing! This is not a great idea, for demo only. 
			// Don't try at home!!! :-)
		}
		
	}
}