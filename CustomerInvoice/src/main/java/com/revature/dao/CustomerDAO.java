package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerDAO {
	
	public int createCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	public void updateCustomer(Customer customer);
	public void deleteCustomerById(int id);
	
}
