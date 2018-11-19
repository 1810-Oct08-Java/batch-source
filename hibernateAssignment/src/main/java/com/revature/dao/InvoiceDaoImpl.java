package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public List<Invoice> getAllInvoice() {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		
		List<Invoice> caves = s.createQuery("from Invoice", Invoice.class).list();
		s.close();
		return caves;
	}

	@Override
	public Invoice getInvoice(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Invoice c = s.load(Invoice.class, id);
		System.out.println(c);
		s.close();
		return c;
	}

	@Override
	public int createInvoice(Invoice in) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int pk = (int) s.save(in);
		
		tx.commit();
		s.close();
		return pk;
	}

	@Override
	public void updateInvoice(Invoice in) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		s.update(in);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteInvoiceById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice c = s.get(Invoice.class, id);
		if (c!=null) {
			s.delete(c);
		}
		tx.commit();
		s.close();
	}

}
