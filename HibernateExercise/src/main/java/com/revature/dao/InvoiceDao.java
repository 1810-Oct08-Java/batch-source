package com.revature.dao;

import java.util.List;
import com.revature.model.Customer;

public interface InvoiceDao {
	public List<Customer> getCustomers();
	public Customer getCustomerById(int id);
	public int createCustomer(Customer c);
	public void updateCustomer(Customer c);
	public void deleteCustomerById(int id);
}
