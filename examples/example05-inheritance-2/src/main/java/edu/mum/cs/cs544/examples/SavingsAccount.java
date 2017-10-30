package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
	private double overdraftLimit;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(double balance, double overdraftLimit) {
		super(balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
}
