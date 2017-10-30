package edu.mum.cs.cs544.timesheet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.timesheet.util.TimesheetResponse;

@RestController
public class SessionController {


	@RequestMapping(value = "course/all", method = RequestMethod.GET, produces = {"application/json" })
	public TimesheetResponse getAllCourses() {

		TimesheetResponse response = new TimesheetResponse();

		//my code

		return response;
	}
}
