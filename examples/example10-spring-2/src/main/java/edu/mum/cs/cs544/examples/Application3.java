package edu.mum.cs.cs544.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application3 {
	public static void main(String[] args) {
		System.out.println("1");
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig3.xml");

		System.out.println("2");
		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		
		System.out.println("3");
		customerService.addCustomer("Frank Brown");
		
		System.out.println("4");
		((ClassPathXmlApplicationContext)context).destroy();

	}
}