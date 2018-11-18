package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice;

public interface InvoiceDao {
	public Invoice getInvoiceById(int id);
	public List<Invoice> getInvoices();
	public void updateInvoice(Invoice i);
	public int createInvoice(Invoice i);
	public void deleteInvoice(int i);

}
