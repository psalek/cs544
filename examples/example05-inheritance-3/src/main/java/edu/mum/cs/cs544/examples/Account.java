package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long number;
	
	private double balance;
	
	public Account() {
		super();
	}

	public Account(double balance) {
		super();
		this.balance = balance;
	}
	
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account# " + number + ", AccountType: " + this.getClass().getSimpleName() + ", Balance = " + balance;
	}

}
