package edu.mum.cs.cs544.examples;

import org.springframework.stereotype.Repository;

@Repository
public class DataAccess {
	public Account loadAccount(long accountNumber) {
		// In reality this will go to DB and fetch a real Account object
		if(1234L == accountNumber) {
			return new Account(accountNumber);
		}
		else {
			return null;
		}
	}
	
	public void saveAccount(Account account) {
		// Do nothing. In reality, save to DB.
	}
}