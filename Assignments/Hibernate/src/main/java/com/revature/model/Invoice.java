package com.revature.model;

import java.sql.Date;

public class Invoice {
// invoice id, date, amount
	private int id;
	private Date dateOfInvoice;
	private double amount;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int id, Date date, double amount) {
		super();
		this.id = id;
		this.dateOfInvoice = date;
		this.amount = amount;
	}
	public Invoice(double amount) {
		super();
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return dateOfInvoice;
	}
	public void setDate(Date date) {
		this.dateOfInvoice = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOfInvoice == null) ? 0 : dateOfInvoice.hashCode());
		result = prime * result + id;
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
		if (dateOfInvoice == null) {
			if (other.dateOfInvoice != null)
				return false;
		} else if (!dateOfInvoice.equals(other.dateOfInvoice))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", date=" + dateOfInvoice + ", amount=" + amount + "]";
	}
	
}
