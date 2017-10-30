package edu.mum.cs.cs544.examples;

import javax.persistence.Entity;

@Entity
public class StuffedAnimal extends Toy {
	
	private String species;

	public StuffedAnimal(String description, String species) {
		super(description);
		this.species = species;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

}
