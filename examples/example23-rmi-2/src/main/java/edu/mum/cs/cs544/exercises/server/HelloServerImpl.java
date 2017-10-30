package edu.mum.cs.cs544.exercises.server;

import java.rmi.RemoteException;

import edu.mum.cs.cs544.exercises.client.Person;

public class HelloServerImpl implements HelloServer {

	public HelloServerImpl() throws RemoteException {
		super();
	}

	public String sayHello(Person person) {
		System.out.println("Calling HelloServerImpl with " + person);
		return "Hello " + person;
	}
}
