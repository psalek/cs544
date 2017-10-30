package edu.mum.cs.cs544.examples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Country.All", query = "from Country") 
})
public class Country {
	@Id()
	@Column(name="country_id")
	@GeneratedValue
	private long id;
	
	@Column(name="country")
	private String name;
	
	public Country() {
		super();
	}
	
	@Override
	public String toString() {
		return String.format("%03d %s", id, name);
	}

}
