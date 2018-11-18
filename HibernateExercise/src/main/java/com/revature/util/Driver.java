package com.revature.util;

import java.sql.Date;
import java.util.List;

import com.revature.beans.Invoice;
import com.revature.dao.InvoiceDao;
import com.revature.dao.InvoiceDaoImpl;

public class Driver {
	
	public static void main(String args[]) {
		
		Invoice inv = new Invoice(Date.valueOf("2018-11-17"), 250);
		Invoice inv1 = new Invoice(Date.valueOf("2018-11-16"), 350);
		Invoice inv2 = new Invoice(Date.valueOf("2018-11-15"), 450);
		Invoice inv3 = new Invoice(Date.valueOf("2018-11-14"), 550);
		
		InvoiceDao invDao = new InvoiceDaoImpl();
		
		//Add invoices to Table
		invDao.addInvoice(inv);
		invDao.addInvoice(inv1);
		invDao.addInvoice(inv2);
		invDao.addInvoice(inv3);
		
		//Print all Invoices
		List<Invoice> result = invDao.getInvoices();
		System.out.println(result);
		
		//Print invoice by ID
		System.out.println(invDao.getInvoiceById(1));
		
		//Update Invoice
		//invDao.updateInvoice(inv3);
		
		//Delete Invoice by ID
		invDao.deleteInvoice(3);
	}

}
