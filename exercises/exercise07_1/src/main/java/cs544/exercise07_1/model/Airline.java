package cs544.exercise07_1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Airline {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "airline")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airline() {
	}

	public Airline(String name) {
		this.name = name;
	}

	/* Getters & Setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collections Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) {
			flight.setAirline(this);
			success = true;
		}
		return success;
	}

	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirline(null);
			success = true;
		}
		return success;
	}
}
