package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Customer;
import com.revature.models.Invoice;
import com.revature.util.HibernateUtil;

public class CustomerDaoImp implements CustomerDAO{

	@Override
	public int createCustomer(Customer customer) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int customerPk = (int) s.save(customer);
		tx.commit();
		s.close();
		return customerPk;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session s = HibernateUtil.getSession();
//		String hql = "from Customer where id=:idVar";
//		Query<Customer> q = s.createQuery(hql,Customer.class);
//		q.setParameter("idVar", id);
//		Customer customer = q.getSingleResult();
		Customer customer = s.get(Customer.class, id);
		s.close();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session s = HibernateUtil.getSession();
		List<Customer> customers = s.createQuery("from Customer", Customer.class).list();
		s.close();
		return customers;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(customer);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Customer c = s.get(Customer.class, id);
		if (c!=null)
			s.delete(c);
		tx.commit();
		s.close();
	}

}
