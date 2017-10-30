package edu.mum.cs.cs544.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCar {

    public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		
		customerService.createRecords();
		customerService.readRecords();
    }
}
