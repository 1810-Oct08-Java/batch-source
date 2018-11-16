package com.revature.models;

import java.sql.Date;

public class Invoice {
	
	private int id;
	private Date invoiceDate;
	private double amount;
	private Customer customer;
	
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(Date invoiceDate, double amount, Customer customer) {
		super();
		this.invoiceDate = invoiceDate;
		this.amount = amount;
		this.customer = customer;
	}

	public Invoice(int id, Date invoiceDate, double amount, Customer customer) {
		super();
		this.id = id;
		this.invoiceDate = invoiceDate;
		this.amount = amount;
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + id;
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceDate=" + invoiceDate + ", amount=" + amount + ", customer=" + customer
				+ "]";
	}

	
	
}
