package edu.mum.cs.cs544.examples;

public class AccountDAOMockImpl implements AccountDAO {

	public Account loadAccount(long accountNumber) {
		System.out.println("Mock implementation of loadAccount is called");
		return new Account(accountNumber);
	}

	public void saveAccount(Account account) {
		System.out.println("Mock implementation of saveAccount is called");
		// Do nothing!
		return;
	}

}
