package cs544.exercise15_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
	public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");       
	}
}
