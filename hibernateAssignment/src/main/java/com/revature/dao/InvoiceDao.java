package com.revature.dao;

import java.util.List;

import com.revature.model.Invoice;

public interface InvoiceDao {
	public List<Invoice> getAllInvoice();
	public Invoice getInvoice(int id);
	public int createInvoice(Invoice in);
	public void updateInvoice(Invoice in);
	public void deleteInvoiceById (int id);
}
