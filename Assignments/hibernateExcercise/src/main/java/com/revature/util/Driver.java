package com.revature.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import com.revature.dao.CustomerDao;
import com.revature.dao.CustomerDaoImpl;
import com.revature.dao.InvoiceDao;
import com.revature.dao.InvoiceDaoImpl;
import com.revature.model.Customer;
import com.revature.model.Invoice;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
		
		CustomerDao cd = new CustomerDaoImpl();
		InvoiceDao ivd = new InvoiceDaoImpl();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		Invoice i = new Invoice(calobj.getTime(),(float)100.00);
		int id = ivd.createInvoice(i);
		i.setId(id);
		
//		cd.createCustomer(new Customer("Joe Montana","773-657-5467",i));
//		cd.createCustomer(new Customer("John Smith", "777-444-4444",i));
//		cd.deleteCustomerById(2);
//		ivd.deleteInvoice(8);
		
//		Customer c = cd.getCustomerById(1);
//		System.out.println(c);
		
//		Invoice i = ivd.getInvoiceById(1);
//		System.out.println(i);
		
//		List<Invoice> lc = ivd.getInvoices();
//		for(Invoice c: lc) {
//			System.out.println(c);
//		}
		
		/*What is needed to make this work?*/
//		List<Customer> lc = cd.getCustomers();
//		for(Customer c: lc) {
//			System.out.println(c);
//		}
		
//		Customer c = new Customer(1,"Joe MontaNNa","343-454-3434", i);
//		cd.updateCustomer(c);
		
		System.out.println(ivd.getInvoices());
	}

}
