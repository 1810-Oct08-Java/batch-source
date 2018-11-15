package allo.model;

import java.sql.Date;

public class Invoice {


private int id;
private Date invoice_date;
private double amount;


public Invoice() {
	super();
	// TODO Auto-generated constructor stub
}


public Invoice(int id, Date date, double amount) {
	super();
	this.id = id;
	this.invoice_date = date;
	this.amount = amount;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Date getInvoice_date() {
	return invoice_date;
}


public void setInvoice_date(Date invoice_date) {
	this.invoice_date = invoice_date;
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
	result = prime * result + ((invoice_date == null) ? 0 : invoice_date.hashCode());
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
	if (invoice_date == null) {
		if (other.invoice_date != null)
			return false;
	} else if (!invoice_date.equals(other.invoice_date))
		return false;
	if (id != other.id)
		return false;
	return true;
}


@Override
public String toString() {
	return "Invoice [id=" + id + ", invoice_date=" + invoice_date + ", amount=" + amount + "]";
}














} 
