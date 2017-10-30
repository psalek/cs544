package edu.mum.cs.cs544.examples;


import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

