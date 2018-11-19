package com.revature.model;

import java.sql.Date;

public class Invoice implements InvoiceDao {
	private int id;
	private Date invoiceDate;
	private double amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	
	public String toString() {
		return "Id: " + id + " amount: " + amount + " date: " + invoiceDate;
	}

}
