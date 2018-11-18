package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Customer;
import com.revature.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Customer getCustomerById(int id) {
		Session s = HibernateUtil.getSession();
		Customer c = s.get(Customer.class, id);
		System.out.println(c);
		s.close();
		return c;
	}

	@Override
	public List<Customer> getCustomers() {
		Session s = HibernateUtil.getSession();
		List<Customer> customers = s.createQuery("from Customer", Customer.class).list();
		for(Customer c : customers) {
			System.out.println(c);
		}
		s.close();
		return customers;
	}

	@Override
	public int createCustomer(Customer c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int customerPK = (int) s.save(c);
		tx.commit();
		s.close();
		return customerPK;
		
	}

	@Override
	public void updateCustomer(Customer c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Customer cu = (Customer) s.get(Customer.class, c.getId());
		cu.setInvoice(c.getInvoice());
		cu.setName(c.getName());
		s.update(cu);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteCustomerById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Customer c = (Customer) s.get(Customer.class, id);
		if(c != null) {
			s.delete(c);
		}
		tx.commit();
		s.close();
		
	}

}
