package cs544.exercise24_1.sender;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSSenderApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"springconfigsender.xml");
		JMSSender jmssender = context.getBean("jmsSender", JMSSender.class);
		Person person = new Person("John", "Doe");
		jmssender.send(person);
		context.close();
	}
}
