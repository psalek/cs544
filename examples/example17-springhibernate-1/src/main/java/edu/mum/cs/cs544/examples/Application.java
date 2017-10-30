package edu.mum.cs.cs544.examples;


import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;
import edu.mum.cs.cs544.examples.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		
		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		
		List<Customer> customers = customerService.getCustomerList(new Country("United States"));
        for (Customer customer : customers) {
            System.out.println(customer);
        }

		//close resources
        context.close(); 
		
	}

}
