package cs544.exercise00_1.domain;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private List<Phone> phones = new LinkedList<>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private List<Email> emails = new LinkedList<>();

	public Contact() {
		super();
	}

	public Contact(String name) {
		super();
		this.name = name;
	}

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

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public boolean addPhone(Phone p) {
		return phones.add(p);
	}

	public boolean removePhone(Phone p) {
		return phones.remove(p);
	}

	public boolean addEmail(Email e) {
		return emails.add(e);
	}

	public boolean removeEmail(Email e) {
		return emails.remove(e);
	}
}
