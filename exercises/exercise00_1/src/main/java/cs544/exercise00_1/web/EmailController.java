package cs544.exercise00_1.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.exercise00_1.domain.Contact;
import cs544.exercise00_1.domain.Email;
import cs544.exercise00_1.service.ContactService;

@Controller
public class EmailController {
	
	@Resource
	private ContactService contactService;
	
	@RequestMapping(value="/contacts/{contactid}/addEmail", method=RequestMethod.POST)
	public String addPhone(Email email, @PathVariable long contactid) {
		Contact c = contactService.getContact(contactid);
		c.addEmail(email);
		contactService.updateContact(c);
		return "redirect:/contacts/" + contactid;
	}

	@RequestMapping(value="/contacts/{contactid}/removeEmail", method=RequestMethod.POST)
	public String removePhone(Email email, @PathVariable long contactid) {
		Contact c = contactService.getContact(contactid);
		c.removeEmail(email);
		contactService.updateContact(c);
		return "redirect:/contacts/" + contactid;
	}

}
