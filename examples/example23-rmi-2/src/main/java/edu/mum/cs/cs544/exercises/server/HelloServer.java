package edu.mum.cs.cs544.exercises.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.mum.cs.cs544.exercises.client.Person;

public interface HelloServer extends Remote {
	public String sayHello(Person person) throws RemoteException;
}
