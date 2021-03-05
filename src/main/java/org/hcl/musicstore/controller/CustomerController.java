package org.hcl.musicstore.controller;

import java.util.Optional;

import org.hcl.musicstore.model.Admin;
import org.hcl.musicstore.model.Customer;
import org.hcl.musicstore.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/savecustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		customerService.updateAndSaveCustomer(customer);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@PostMapping(value="/login")
	public ResponseEntity<?> Login(@RequestBody Customer customer) throws Exception {

		Customer customer1 = customerService.findCustomerByUsername(customer.getUsername());

		if(customer1.getPassword().equals(customer.getPassword())) {
				return ResponseEntity.ok(customer);
		}


		return ResponseEntity.badRequest().body("Invalid admin credentials");
	}

	@PostMapping(value="/register")
	public ResponseEntity<?> Register(@RequestBody Customer customer) throws Exception {
		customerService.createCustomer(customer);
		return ResponseEntity.badRequest().body("Invalid admin credentials");
	}



	@GetMapping("/customer")
	public Iterable<Customer> getCustomerDetails(){
		return customerService.findAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws Exception{
		Optional<Customer> customer = customerService.findCustomerById(id);
		
		return customer.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("/customer/{name}")
	public Customer searchCustomerByUserame(@PathVariable String name) throws Exception {
		return customerService.findCustomerByUsername(name);
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Integer id) throws Exception{
		logger.info("Deleting customer with id: "+ id);
		boolean isRemoved = customerService.deleteCustomerById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
}