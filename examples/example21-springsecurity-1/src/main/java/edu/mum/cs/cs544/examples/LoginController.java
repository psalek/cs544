package edu.mum.cs.cs544.examples;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcomePage");
		return model;
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model, Principal principal) {
		model.addAttribute("user", principal.getName());
		return "accessDenied";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model, Principal principal) {
		model.addAttribute("user", principal.getName());
		return "adminPage";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage(ModelMap model, Principal principal) {
		model.addAttribute("user", principal.getName());
		return "userPage";
	}

}