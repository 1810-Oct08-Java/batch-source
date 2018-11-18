package com.revature.dao;
import java.util.List;
import com.revature.beans.Invoice;

public interface InvoiceDao {
	public List<Invoice> getInvoices();
	public Invoice getInvoiceById(int id);
	public int addInvoice(Invoice inv);
	public void updateInvoice(Invoice inv);
	public void deleteInvoice(int id);
}
