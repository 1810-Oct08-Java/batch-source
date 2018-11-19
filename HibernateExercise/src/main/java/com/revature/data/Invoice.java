package com.revature.data;

import java.util.Date;

public class Invoice {
	
	public Invoice(int id, Date dated, int amount) {
		super();
		this.id = id;
		this.dated = dated;
		this.amount = amount;
	}

	private int id;
	private Date dated;
	private int amount;
	
	public Invoice() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((dated == null) ? 0 : dated.hashCode());
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
		if (amount != other.amount)
			return false;
		if (dated == null) {
			if (other.dated != null)
				return false;
		} else if (!dated.equals(other.dated))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", dated=" + dated + ", amount=" + amount + "]";
	}
	
}