package edu.mum.cs.cs544.exercises.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.cs.cs544.exercises.server.HelloServer;

public class RmiClientApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfigclient.xml");
		HelloServer remoteServerObject = context.getBean("helloserver", HelloServer.class);
		String result = remoteServerObject.sayHello(new Person("Frank", "Brown"));
		System.out.println("RMI Client: " + result);
	}
}
