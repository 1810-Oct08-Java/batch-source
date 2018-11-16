package com.revature.util;

import java.sql.Date;
import java.util.List;

//import org.hibernate.Session;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDaoImp;
import com.revature.dao.InvoiceDAO;
import com.revature.dao.InvoiceDaoImp;
import com.revature.models.Customer;
import com.revature.models.Invoice;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();

//		CustomerDAO cdao = new CustomerDaoImp();

		Customer c1 = new Customer("Wendy Barker", "(879) 669-8554");
		Customer c2 = new Customer("Toby Soto", "(490) 794-9233");
		Customer c3 = new Customer("Alexander Choi","(259) 478-4438");
		Customer c4 = new Customer("Tania Padilla","(394) 259-3355");
//		
//		cdao.createCustomer(c1);
//		cdao.createCustomer(c2);
//		cdao.createCustomer(c3);
//		cdao.createCustomer(c4);
//
//		List<Customer> customers = cdao.getAllCustomers();
//		for(Customer c: customers)
//			System.out.println(c);
//		
//		cdao.deleteCustomerById(4);
		
		InvoiceDAO idao = new InvoiceDaoImp();

		Invoice i1 = new Invoice(Date.valueOf("2018-03-16"),32.12,c1);
		Invoice i2 = new Invoice(Date.valueOf("2018-04-22"),65.91,c2);
		Invoice i3 = new Invoice(Date.valueOf("2018-06-12"),59.49,c3);
		Invoice i4 = new Invoice(Date.valueOf("2018-07-28"),78.21,c2);
		Invoice i5 = new Invoice(Date.valueOf("2018-07-31"),78.20,c1);
		Invoice i6 = new Invoice(Date.valueOf("2018-08-05"),41.61,c3);
		Invoice i7 = new Invoice(Date.valueOf("2018-10-10"),69.91,c2);
		Invoice i8 = new Invoice(Date.valueOf("2018-11-14"),47.40,c1);
		
		idao.createInvoice(i1);
		idao.createInvoice(i2);
		idao.createInvoice(i3);
		idao.createInvoice(i4);
		idao.createInvoice(i5);
		idao.createInvoice(i6);
		idao.createInvoice(i7);
		idao.createInvoice(i8);
		
		List<Invoice> invoices = idao.getAllInvoices();
		for(Invoice i: invoices)
			System.out.println(i);
		
		idao.deleteInvoiceById(4);
	}

}
