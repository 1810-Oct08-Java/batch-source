package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Customer;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao {

	public List<Customer> getCustomers() {
		Session s = HibernateUtil.getSession();
		List<Customer> cl = s.createQuery("from Customer", Customer.class).list();
		s.close();
		return cl;
	}

	public Customer getCustomerById(int id) {
		Session s = HibernateUtil.getSession();
		Customer c = s.load(Customer.class, id);
		s.close();
		return c;
	}

	public int createCustomer(Customer c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int customerPK = (Integer) s.save(c);
		tx.commit();
		s.close();
		return customerPK;
	}

	public void updateCustomer(Customer c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(c);
		tx.commit();
		s.close();
	}

	public void deleteCustomerById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, id);
		if(c != null) {
			s.delete(c);
		}
		tx.commit();
		s.close();
	}

}
