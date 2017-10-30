package cs544.exercise07_1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Airplane {
	@Id
	@GeneratedValue
	private long id;
	private String serialnr;
	private String model;
	private int capacity;
	@OneToMany(mappedBy="airplane")
	@OrderBy("departureDate, departureTime")
	private List<Flight> flights;

	/* Constructors */
	public Airplane() {
	}

	public Airplane(String serialnr, String model, int capacity) {
		this.serialnr = serialnr;
		this.model = model;
		this.capacity = capacity;
	}

	/* Getters and Setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialnr() {
		return serialnr;
	}

	public void setSerialnr(String serialnr) {
		this.serialnr = serialnr;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/* Collection Methods */
	public boolean addFlight(Flight flight) {
		boolean success = false;
		if (flights.add(flight)) { 
			flight.setAirplane(this);
			success = true;
		}
		return success;
	}
	
	public boolean removeFlight(Flight flight) {
		boolean success = false;
		if (flights.remove(flight)) {
			flight.setAirplane(null);
			success = true;
		}
		return success;
	}
}
