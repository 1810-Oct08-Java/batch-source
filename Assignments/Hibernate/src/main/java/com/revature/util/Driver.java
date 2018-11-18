package com.revature.util;

import org.hibernate.Session;

import com.revature.dao.InvoiceDao;
import com.revature.dao.InvoiceDaoImpl;
import com.revature.model.Invoice;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
		InvoiceDao id = new InvoiceDaoImpl();
		
		Invoice i1 = new Invoice(60.99);
		Invoice i2 = new Invoice(21.50);
		Invoice i3 = new Invoice(50.55);
		
		id.createInvoice(i1);
		id.createInvoice(i2);
		id.createInvoice(i3);
	}
}
