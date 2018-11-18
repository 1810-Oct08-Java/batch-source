package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Invoice;
import com.revature.util.HibernateUtil;

public class InvoiceDaoImpl implements InvoiceDao{

	@Override
	public Invoice getInvoiceById(int id) {
		Session s = HibernateUtil.getSession();
		Invoice i = s.get(Invoice.class, id);
		System.out.println(i);
		s.close();
		return i;
	}

	@Override
	public List<Invoice> getInvoices() {
		Session s = HibernateUtil.getSession();
		List<Invoice> Invoices = s.createQuery("from Invoice", Invoice.class).list();
		for(Invoice i : Invoices) {
			System.out.println(i);
		}
		s.close();
		return Invoices;
	}

	@Override
	public void updateInvoice(Invoice i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice iu = (Invoice) s.get(Invoice.class, i.getId());
		iu.setAmount(i.getAmount());
		iu.setDate(i.getDate());
		s.update(iu);
		tx.commit();
		s.close();
		
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
	public void deleteInvoice(int i) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Invoice inv = (Invoice) s.get(Invoice.class, i);
		if(inv != null) {
			s.delete(inv);
		}
		tx.commit();
		s.close();	
	}
	
	public List<Invoice> listInvoice () {
		Session s = HibernateUtil.getSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Invoice> cq = cb.createQuery(Invoice.class);
		Root<Invoice> root = cq.from(Invoice.class);
		cq.select(root);
		cq.where(cb.equal(root.get("amount"),100));
		Query<Invoice> q = s.createQuery(cq);
		List<Invoice> invoices = q.list();
		s.close();
		return invoices;
	}

}
