package com.revature.dao;

import java.util.List;

import com.revature.models.Invoice;

public interface InvoiceDAO {
	public int createInvoice(Invoice invoice);
	public Invoice getInvoiceById(int id);
	public List<Invoice> getAllInvoices();
	public void updateInvoice(Invoice invoice);
	public void deleteInvoiceById(int id);
}
