package edu.mum.cs.cs544.examples.restdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs.cs544.examples.restdemo.domain.Address;
import edu.mum.cs.cs544.examples.restdemo.domain.Customer;
import edu.mum.cs.cs544.examples.restdemo.service.CustomerService;

/**
 * @author Anil
 *
 */
@Controller
// @RestController This also can be used instead of @Controller so that we don't
// have to user @ResponseBody annotation.
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostConstruct
	public void populateCustomers() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Anil", "K C", "1234567890", new Address("Fairfield", "IA", "1000 N St", 52557, "USA")));
		customers.add(new Customer("Kamal", "Nepal", "12312414232", new Address("Thames", "BG", "1000 N St", 23462, "UK")));
		customers.add(new Customer("Amit", "K C", "1325112145",	new Address("MorganTown", "WV", "2605 Chestnut Hls", 26505, "USA")));
		customerService.saveAll(customers);
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Customer getCustomer(@PathVariable long customerId) {
		return customerService.getCustomerById(customerId);
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteCustomer(@PathVariable long customerId) {

		JSONObject responseBody = new JSONObject();
		HttpStatus httpStatus = HttpStatus.OK;

		if (customerService.deleteCustomerById(customerId)) {

			responseBody.put("message", "Successfully deleted");
			responseBody.put("customerId", customerId);

		} else {

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			responseBody.put("message", "Unable to delete due internal server error");
			responseBody.put("customerId", customerId);

		}
		return new ResponseEntity<String>(responseBody.toString(), httpStatus);
	}

	@RequestMapping(value = "/{customerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) {

		Customer savedCustomer = customerService.getCustomerById(customerId);

		JSONObject responseBody = new JSONObject();
		HttpStatus httpStatus = HttpStatus.OK;

		if (savedCustomer == null) {

			responseBody.put("message", "Customer not found");
			responseBody.put("customerId", customerId);
			httpStatus = HttpStatus.BAD_REQUEST;

		} else {

			savedCustomer.setFirstName(customer.getFirstName());
			savedCustomer.setLastName(customer.getLastName());
			savedCustomer.setPhoneNumber(customer.getPhoneNumber());
			savedCustomer = customerService.updateCustomer(savedCustomer);

			responseBody.put("message", "Customer successfully updated");
			responseBody.put("customer", new JSONObject(savedCustomer));
		}
		return new ResponseEntity<String>(responseBody.toString(), httpStatus);
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {

		JSONObject responseBody = new JSONObject();
		HttpStatus httpStatus = HttpStatus.OK;

		customer = customerService.addCustomer(customer);
		responseBody.put("message", "Customer successfully added");
		responseBody.put("customer", new JSONObject(customer));

		return new ResponseEntity<String>(responseBody.toString(), httpStatus);
	}

	@RequestMapping(value = "/{customerId}/addresses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addCustomerAddress(@PathVariable long customerId, @RequestBody Address address) {

		Customer savedCustomer = customerService.getCustomerById(customerId);

		JSONObject responseBody = new JSONObject();
		HttpStatus httpStatus = HttpStatus.OK;

		if (savedCustomer == null) {

			responseBody.put("message", "Customer not found");
			responseBody.put("customerId", customerId);
			httpStatus = HttpStatus.BAD_REQUEST;

		} else {
			savedCustomer.setAddress(address);
			savedCustomer = customerService.updateCustomer(savedCustomer);

			responseBody.put("message", "Customer address successfully added");
			responseBody.put("customerId", customerId);
			responseBody.put("address", new JSONObject(savedCustomer.getAddress()));
		}

		return new ResponseEntity<String>(responseBody.toString(), httpStatus);
	}

	@RequestMapping(value = "/{customerId}/addresses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> getCustomerAddress(@PathVariable long customerId) {

		Customer savedCustomer = customerService.getCustomerById(customerId);

		JSONObject responseBody = new JSONObject();
		HttpStatus httpStatus = HttpStatus.OK;

		if (savedCustomer == null) {

			responseBody.put("message", "Customer not found");
			responseBody.put("customerId", customerId);
			httpStatus = HttpStatus.BAD_REQUEST;

		} else {
			responseBody.put("customerId", customerId);
			responseBody.put("address", new JSONObject(savedCustomer.getAddress()));
		}

		return new ResponseEntity<String>(responseBody.toString(), httpStatus);
	}

	@RequestMapping(value = "/{customerId}/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Customer getCustomerInXML(@PathVariable long customerId) {
		return customerService.getCustomerById(customerId);
	}

}
