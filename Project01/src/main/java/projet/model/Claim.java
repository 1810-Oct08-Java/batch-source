package projet.model;

import java.io.Serializable;

public class Claim implements Serializable {


	private static final long serialVersionUID = 1L;

	private int claimID;
	private double amount;
	private String description;
	private String status;
	private String initDate;
	private String decisionDate;
	private String employeeID;


	public Claim () {}


	public Claim(int claimID, double amount, String description, String status, String initDate, String decisionDate,
			String employeeID) {
		super();
		this.claimID = claimID;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.initDate = initDate;
		this.decisionDate = decisionDate;
		this.employeeID = employeeID;
	}




	public int getClaimID() {
		return claimID;
	}

	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInitDate() {
		return initDate;
	}

	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	public String getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + claimID;
		result = prime * result + ((decisionDate == null) ? 0 : decisionDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
		result = prime * result + ((initDate == null) ? 0 : initDate.hashCode());
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
		Claim other = (Claim) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (claimID != other.claimID)
			return false;
		if (decisionDate == null) {
			if (other.decisionDate != null)
				return false;
		} else if (!decisionDate.equals(other.decisionDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		return true;
	}

	@Override
	public String toString() {

		String thisDecision;
		String thisstatus;

	if(status==null){
			thisstatus="Pending";
	} else
			if (status.equals("0")){thisstatus="Rejected";}	else
			if (status.equals("1")){thisstatus="Approved";}	else
							{thisstatus=status;}
				
		
	if ( decisionDate == null) { thisDecision="TBD"; } else { thisDecision=decisionDate;}
		
		return " <tr> <td> " + claimID + " </td> <td> " + amount + " </td> <td> " + description + " </td> <td> "
				+ thisstatus + " </td> <td> " + initDate + " </td> <td> " + thisDecision + " </td> <td> " + employeeID
				+ " </td> </tr> ";
	}


















	
}
