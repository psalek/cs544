package edu.mum.cs.cs544.examples;

import org.springframework.stereotype.Repository;

@Repository("AccountDAOImpl")
public class AccountDAOImpl implements AccountDAO {
	DataAccess dataAccess = new DataAccess();

	public Account loadAccount(long accountNumber) {
		System.out.println("Real implementation of loadAccount is called");
		return dataAccess.loadAccount(accountNumber);
	}

	public void saveAccount(Account account) {
		System.out.println("Real implementation of saveAccount is called");
		dataAccess.saveAccount(account);
	}

}
