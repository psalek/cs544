package cs544.exercise00_1.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.exercise00_1.domain.Contact;
import cs544.exercise00_1.domain.Phone;
import cs544.exercise00_1.service.ContactService;

@Controller
public class PhoneController {
	
	@Resource
	private ContactService contactService;
	
	@RequestMapping(value="/contacts/{contactid}/addPhone", method=RequestMethod.POST)
	public String addPhone(Phone phone, @PathVariable long contactid) {
		Contact c = contactService.getContact(contactid);
		c.addPhone(phone);
		contactService.updateContact(c);
		return "redirect:/contacts/" + contactid;
	}

	@RequestMapping(value="/contacts/{contactid}/removePhone", method=RequestMethod.POST)
	public String removePhone(Phone phone, @PathVariable long contactid) {
		Contact c = contactService.getContact(contactid);
		c.removePhone(phone);
		contactService.updateContact(c);
		return "redirect:/contacts/" + contactid;
	}

}
