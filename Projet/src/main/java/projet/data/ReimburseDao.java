package projet.data;

import java.util.*;

import projet.model.*;

public interface ReimburseDao {

Employee login (String username, String password);
//	return an instance of the employee
	public Employee getEmployee	(String username);


//	Employee actions
	public boolean startClaim		(String username, String description, double amount);
	public boolean changeEmail		(String username, String email);


//	Lists of employee accessible data
	public ArrayList<Claim> getAllClaims		(String username);
	public List<Claim> getPendingClaims	(String username);
	public List<Claim> getResolvedClaims	(String username);


//	admin privilege required
//	public boolean setEmployee	(Employee employee);
public boolean setEmployee	(
			String username, String password, String firstname, String lastname);
public boolean setEmployee	(
	String username, String password, String firstname, String lastname, String email);

public List<Employee> getEmployeeList		();
public List<Claim> getAllClaims		();
public boolean approveClaim(int claimID);
public boolean rejectClaim (int claimID);

}
