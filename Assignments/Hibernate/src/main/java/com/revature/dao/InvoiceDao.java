package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice;

public interface InvoiceDao {
	
	public List<Invoice> getInvoices();
	public Invoice getInvoiceById(int id);
	public int createInvoice(Invoice i);
	public void updateInvoice(Invoice i);
	public void deleteInvoiceById(int id);

}
