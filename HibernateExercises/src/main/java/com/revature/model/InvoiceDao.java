package com.revature.model;

import java.sql.Date;

public interface InvoiceDao {

	public abstract int getId();
	public abstract void setId(int id);
	public abstract double getAmount();
	public abstract void setAmount(double amount);
	public abstract Date getInvoiceDate();
	public abstract void setInvoiceDate(Date invoiceDate);
}
