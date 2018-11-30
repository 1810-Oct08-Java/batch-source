package com.revature.controllers;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.intercom.AccountClient;
import com.revature.models.Account;
import com.revature.models.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private Logger logger = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	AccountClient accountClient;
	
	private List<Customer> customers = new ArrayList<>();
	
	public CustomerController() {
		customers.add(new Customer(1, "Kurt Vonnegut", "kvon@gmail.com", null));
		customers.add(new Customer(2, "Kenny Thompson", "kthompson@gmail.com", null));
		customers.add(new Customer(3, "Tom Brady", "tbrady@gmail.com", null));
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		logger.info("CustomerController.findAllCustomers()");
		return customers;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id")int customerId) {
		logger.info("CustomerController.getCustomerById(): "+customerId);
		Customer customer = customers.stream().filter(cust -> cust.getCustomerId() == customerId).findFirst().get();
		List<Account> accounts = accountClient.getAccountsByCustomerId(customerId);
		customer.setAccounts(accounts);
		return customer;
	}
	
}
