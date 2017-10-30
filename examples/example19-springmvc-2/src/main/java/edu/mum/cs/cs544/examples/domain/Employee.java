package edu.mum.cs.cs544.examples.domain;

public class Employee extends Person {

	private Double salary;
	
	public Employee(Person person, Double salary) {	
		super(person.ssn, person.name, person.gender, person.birthday);		
		this.salary = salary;
	}
	
	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return String.format("%s Salary: %,10.2f", super.toString(), salary);
	}
}
