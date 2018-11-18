package com.revature.beans;

import java.sql.Date;

public class Invoice {
	
	private int invoiceId;
	private Date date;
	private double amount;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceId, Date date, double amount) {
		super();
		this.invoiceId = invoiceId;
		this.date = date;
		this.amount = amount;
	}
	
	public Invoice(Date date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + invoiceId;
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
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", date=" + date + ", amount=" + amount + "]";
	}
	
	

}
