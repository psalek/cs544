package cs544.exercise00_1.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.exercise00_1.domain.Contact;
import org.hibernate.SessionFactory;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ContactService {
    
	@Resource
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Collection<Contact> getContacts() {
		return sf.getCurrentSession().createQuery("from Contact").list();
	}
	
	public Contact getContact(long id) {
		return (Contact) sf.getCurrentSession().load(Contact.class, id);
	}
	
	public void addContact(Contact contact) {
		sf.getCurrentSession().merge(contact);
	}
	
	public void updateContact(Contact contact) {
		sf.getCurrentSession().merge(contact);
	}
	
	public void deleteContact(Contact contact) {
		sf.getCurrentSession().delete(contact);
	}
}
