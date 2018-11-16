package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImp implements InvoiceDAO {

	@Override
	public int createInvoice(Invoice invoice) {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int invoicePk = (int) s.save(invoice);
		tx.commit();
		return invoicePk;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Invoice invoice = s.get(Invoice.class, id);
		s.close();
		return invoice;
	}

	@Override
	public List<Invoice> getAllInvoices() {
		Session s = HibernateUtil.getSession();
		List<Invoice> invoices = s.createQuery("from Invoice", Invoice.class).list();
		s.close();
		return invoices;
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(invoice);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice c = s.get(Invoice.class, id);
		if (c!=null)
			s.delete(c);
		tx.commit();
		s.close();
	}

}
