package edu.mum.cs.cs544.examples;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@Column(name="address_id")
	@GeneratedValue
	private Long id;
	
	@Column(name="address")
	private String address1;
	
	private String address2;
	
	private String district;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Address: ");
		sb.append(address1);
		
		if(null != address2) {
			sb.append(", ");
			sb.append(address2);
		}
		
		sb.append(", District: ");
		sb.append(district);
		
		sb.append(", ");
		sb.append(city);
		
		return sb.toString();
	}

}
