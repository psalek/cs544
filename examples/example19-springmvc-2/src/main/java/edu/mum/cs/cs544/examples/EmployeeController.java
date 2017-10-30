package edu.mum.cs.cs544.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs544.examples.utils.EmployeeUtils;

@Controller
public class EmployeeController {
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces="text/xml")
	public ModelAndView getEmployeeList() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("employeeList");
		
		mav.addObject("employees", EmployeeUtils.generateEmployeeCollection(10));
		
		return mav;
	}
}