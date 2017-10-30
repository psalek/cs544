package cs544.exercise23_1.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise23_1.server.IGreeting;
import cs544.exercise23_1.server.Person;

public class RMIClient {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigclient.xml");
		IGreeting remoteServer = context
				.getBean("helloserver", IGreeting.class);
		Person person = new Person("John", "Doe");
		String result = remoteServer.getMessage(person);
		System.out.println("Receiving result: " + result);
	}

}
