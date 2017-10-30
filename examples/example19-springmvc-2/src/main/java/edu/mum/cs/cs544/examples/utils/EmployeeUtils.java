package edu.mum.cs.cs544.examples.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import edu.mum.cs.cs544.examples.domain.Employee;

/**
 * This utility class is designed to generate a collection of random employees
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class EmployeeUtils {
	private static final Double BASE_SALARY = 50000.0;
	
	private static final int DEFAULT_COLLECTION_SIZE = 1000000;
	
	private static Random randomGenerator = new Random();
	
	public static void printEmployees(Collection<Employee> collection) {
		for(Employee e : collection) {
			System.out.println(e);
		}
	}
	
	public static Collection<Employee> generateEmployeeCollection() {
		return generateEmployeeCollection(DEFAULT_COLLECTION_SIZE);
	}
	
	public static Collection<Employee> generateEmployeeCollection(int size) {
		if(size < 0) {
			return null;
		}
		
		System.out.printf("Creating a collection of %,d person objects...", size);
		
		Timer.start();
		
		Map<String, Employee> employeeMap = new HashMap<String, Employee>(size);
		
		for(int i = 0; i < size; ++i) {
			Employee employee = createRandomEmployee(i);
			if(employeeMap.containsKey(employee.getSsn())) {
				// Duplicate SSN, discard
				--i;
			}
			else {
				employeeMap.put(employee.getSsn(), employee);
			}
			if(i%10000 == 0) {
				System.out.print(".");
			}
		}
		
		System.out.println("\nFinished creating person objects.\n");
		
		Timer.stop();
		
		return employeeMap.values();
	}
	
	public static Employee createRandomEmployee(int index) {
		return new Employee(PersonUtils.createRandomPerson(index), randomSalary());
	}
	
	public static Double randomSalary() {
		return randomGenerator.nextDouble() * BASE_SALARY + BASE_SALARY;
	}
	
}
