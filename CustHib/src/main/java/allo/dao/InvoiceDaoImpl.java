package allo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import allo.model.*;
import allo.util.HibernateUtil;

class InvoiceDaoImpl implements InvoiceDao {

	@Override
	public List<Invoice> getInvoices() {
		Session s = HibernateUtil.getSession();
		List <Invoice> invoices = s.createQuery("from Invoice", Invoice.class).list();
		s.close();
		return invoices;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Invoice i = s.load(Invoice.class, id);
		s.close();
		return i;
	}

	@Override
	public int createInvoice(Invoice i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int invoicePK = (int) s.save(i);
		tx.commit();
		s.close();
		return invoicePK;
	}

	@Override
	public void updateInvoice(Invoice i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(i);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice i = s.get(Invoice.class, id);
		if(i!=null) {s.delete(i);}
		tx.commit();
		s.close();
	}











}
