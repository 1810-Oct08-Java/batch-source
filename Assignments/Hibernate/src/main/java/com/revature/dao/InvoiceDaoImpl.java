package com.revature.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public List<Invoice> getInvoices() {
		Session s = HibernateUtil.getSession();
		List<Invoice> invoices = s.createQuery("from Cave", Invoice.class).list();
		s.close();
		return invoices;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Invoice i = s.get(Invoice.class, id);
		s.close();
		return i;
	}

	@Override
	public int createInvoice(Invoice i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int invoicePK = (int) s.save(i);
		tx.commit();
		s.close(); // don't close before commit!
		return invoicePK;
	}

	@Override
	public void updateInvoice(Invoice i) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(i);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteInvoiceById(int id) {
		// TODO Auto-generated method stub
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice i = s.get(Invoice.class, id);
		
		if (i != null) {
			s.delete(i);
		}
		tx.commit();
		s.close();
	}

}
