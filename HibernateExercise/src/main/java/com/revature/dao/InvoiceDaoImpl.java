package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao{

	@Override
	public List<Invoice> getInvoices() {
		Session s = HibernateUtil.getSession();
		List<Invoice> invoices = s.createQuery("from Invoice", Invoice.class).list();
		return invoices;
	}

	@Override
	public Invoice getInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Invoice result = s.get(Invoice.class, id);
		s.close();
		return result;
	}

	@Override
	public int addInvoice(Invoice inv) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int invoiceKey = (int) s.save(inv);
		tx.commit();
		s.close();
		return invoiceKey;
	}

	@Override
	public void updateInvoice(Invoice inv) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(inv);
		tx.commit();
		s.close();
		}

	@Override
	public void deleteInvoice(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice result = s.get(Invoice.class, id);
		if(result != null) {
			s.delete(result);
		}
		tx.commit();
		s.close();
		
	}

}
