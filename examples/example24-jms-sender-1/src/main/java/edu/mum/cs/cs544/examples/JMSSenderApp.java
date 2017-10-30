package edu.mum.cs.cs544.examples;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSSenderApp {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigsender.xml");
		JMSSender jmssender = context.getBean("jmsSender", JMSSender.class);
		Person person = new Person("John", "Doe");
		
		for(int i = 0; i < 100; ++i) {
			jmssender.send(person);
			System.out.println("Message#" + i + " sent");
			Thread.sleep(1000);
		}
		context.close();
	}
}
