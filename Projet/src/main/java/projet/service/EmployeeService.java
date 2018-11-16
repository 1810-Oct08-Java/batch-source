package projet.service;

import java.util.*;
import projet.data.*;
import projet.model.*;

public class EmployeeService {

private static EmployeeService eService;

private EmployeeService () {}

public static EmployeeService getEmployeeService () {
	if (eService==null) {	eService = new EmployeeService();	}
	return eService;
}

public Employee getEmployee (String username, String password) {
return ReimburseImplement.getReimburseDao().login(username, password);
}

public Employee getEmployeeInfo (String username) {
return ReimburseImplement.getReimburseDao().getEmployee(username);
}


public boolean registerEmployee (String username, String password, String firstname, String lastname) {
return ReimburseImplement.getReimburseDao().setEmployee(username, password, firstname, lastname);
}


public boolean registerEmployee (String username, String password, String firstname, String lastname, String email) {
return ReimburseImplement.getReimburseDao().setEmployee(username, password, firstname, lastname, email);
}

public boolean changeEmail (String username, String password, String email) {
return ReimburseImplement.getReimburseDao().changeEmail(username, email);
}

public List<Claim> listAllClaim () {
return ReimburseImplement.getReimburseDao().getAllClaims();
}


//	Employee Services
public List<Claim> listPending (String username) {
return ReimburseImplement.getReimburseDao().getPendingClaims(username);
}

public List<Claim> listResolved (String username) {
return ReimburseImplement.getReimburseDao().getResolvedClaims(username);
}

public ArrayList<Claim> listClaims (String username) {
return ReimburseImplement.getReimburseDao().getAllClaims(username);
}

//Admin
public List<Employee> employees () {
return ReimburseImplement.getReimburseDao().getEmployeeList();
}

public boolean approveClaim (int claimID) {
	return ReimburseImplement.getReimburseDao().approveClaim(claimID);
}

public boolean rejectClaim (int claimID) {
	return ReimburseImplement.getReimburseDao().rejectClaim(claimID);
}











}