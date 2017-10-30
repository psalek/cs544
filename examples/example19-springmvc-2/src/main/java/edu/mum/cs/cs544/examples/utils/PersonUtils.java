package edu.mum.cs.cs544.examples.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.mum.cs.cs544.examples.domain.Person;

/**
 * This utility class is designed to generate a collection of random persons
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class PersonUtils {
	private static Random randomGenerator = new Random();
	
	public static void printPersons(Collection<Person> collection) {
		for(Person p : collection) {
			System.out.println(p);
		}
	}
	
	public static List<Person> generateRandomPersonList(int size) {
		if(size < 0) {
			return null;
		}
		
		System.out.printf("Creating a collection of %,d random person objects...", size);
		
		Timer.start();
		
		Map<String, Person> personMap = new HashMap<String, Person>(size);
		
		for(int i = 0; i < size; ++i) {
			Person person = createRandomPerson(i);
			if(personMap.containsKey(person.getSsn())) {
				// Duplicate SSN, discard
				--i;
			}
			else {
				personMap.put(person.getSsn(), person);
			}
			if(i%10000 == 0) {
				System.out.print(".");
			}
		}
		
		System.out.println("\nFinished creating a random roster.\n");
		
		Timer.stop();
		
		List<Person> personList = new ArrayList<Person>(size);
		personList.addAll(personMap.values());
			
		return personList;
	}
	
	public static Person createRandomPerson(int index) {
		return new Person(randomSSN(), randomName(index), randomGender(), randomBirthday());
	}
	
	public static String randomSSN() {
		return String.format("%03d-%02d-%04d", randomGenerator.nextInt(1000), randomGenerator.nextInt(100), randomGenerator.nextInt(10000));
	}
	
	public static String randomName(int index) {
		return String.format("Person%09d", index);
	}
	
	public static Person.Gender randomGender() {
		if(randomGenerator.nextInt(100) > 50)
			return Person.Gender.MALE;
		else
			return Person.Gender.FEMALE;
	}
	
	public static LocalDate randomBirthday() {
		return LocalDate.now().minusDays(randomGenerator.nextInt(365*90)); // Max age is 90 years old
	}
}
