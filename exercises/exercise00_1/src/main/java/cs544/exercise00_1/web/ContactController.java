package cs544.exercise00_1.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.exercise00_1.domain.Contact;
import cs544.exercise00_1.service.ContactService;

@Controller
public class ContactController {
	
	@Resource
	private ContactService contactService;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("contacts", contactService.getContacts());
		return "contactList";
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public String add(Contact contact) {
		contactService.addContact(contact);
		return "redirect:/contacts";
	}

	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public String get(@PathVariable long id, Model model) {
		model.addAttribute("contact", contactService.getContact(id));
		return "contactDetail";
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.POST)
	public String update(Contact contact, @PathVariable long id) {
		contactService.updateContact(contact); // contact.id already set by binding
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable long id) {
		Contact c = contactService.getContact(id);
		contactService.deleteContact(c);
		return "redirect:/contacts";
	}
}
