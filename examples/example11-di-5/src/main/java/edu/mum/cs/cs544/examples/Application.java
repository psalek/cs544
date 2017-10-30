package edu.mum.cs.cs544.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		AccountService accountService = context.getBean("accountService", AccountService.class);
		
		accountService.deposit(1234L, 2000);
		
	}
}