package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;

@Entity
public class Ball extends Toy {
	private int size;

	public Ball(String description, int size) {
		super(description);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
