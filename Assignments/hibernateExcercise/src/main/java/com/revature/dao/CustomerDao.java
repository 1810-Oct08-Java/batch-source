package com.revature.dao;

import java.util.List;

import com.revature.model.Customer;

public interface CustomerDao {
	
	public Customer getCustomerById(int id);
	public List<Customer> getCustomers();
	public int createCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomerById(int id);

}
