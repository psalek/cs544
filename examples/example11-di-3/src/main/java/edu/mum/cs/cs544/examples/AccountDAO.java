package edu.mum.cs.cs544.examples;

public interface AccountDAO {
	Account loadAccount(long accountNumber);
	void saveAccount(Account account);
}
