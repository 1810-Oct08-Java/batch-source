package projet.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;
import java.util.Date;

import org.apache.log4j.*;

import projet.model.*;
import projet.util.*;





public class ReimburseImplement implements ReimburseDao {

//private static ConnectUtil cu = ConnectUtil.getInstance();

//not in example
private static ReimburseImplement ReimburseDao;
	final static Logger log = Logger.getLogger(ReimburseImplement.class);
private ReimburseImplement () {}


// not in example
public static ReimburseImplement getReimburseDao () {
	if (ReimburseDao == null) {
		ReimburseDao = new ReimburseImplement();
	}	return ReimburseDao;
}



@Override
public Employee login (String username, String password) {
Employee login = null;
//Connection conn = null;
//conn = cu.getConnection();
String sql = "Select * from "
	+ "Employee" + " where username = ? and password = ?";
try
(Connection conn = ConnectUtil.getConnection())
	{
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
login = new Employee (
rs.getString("username"),
rs.getString("password"),
rs.getString("firstname"),
rs.getString("lastname"),
rs.getString("admin"),
rs.getString("email")
);	}
}	catch (SQLException | ClassNotFoundException sqe)	{
sqe.printStackTrace();
}
return login;
}




@Override
public Employee getEmployee (String username) {
Employee emp = null;
//Connection conn = cu.getConnection();
String sql = "Select * from Employee where username = ?";
try
	(Connection conn = ConnectUtil.getConnection() )
	{
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);

ResultSet rs = ps.executeQuery();
if (rs.next()) {
//	log.info("Attempt: getEmployee while loop");
emp = new Employee (
rs.getString("username"),
rs.getString("password"),
rs.getString("firstname"),
rs.getString("lastname"),
rs.getString("admin"),
rs.getString("email")
);	}

System.out.println("" + emp.getUsername());

}	catch (SQLException | ClassNotFoundException sqe)	{
//	log.error("getEmployee: catch block executed");
sqe.printStackTrace();
	}
return emp;
}





@Override
public boolean startClaim	(String username, String description, double amount) {
//	Connection conn = cu.getConnection();
	log.info("Employee attempt to begin a reimbursement claim.");
try
(Connection conn = ConnectUtil.getConnection())
{
String sql = "Insert into Reimburse	(amount, description, employeeID) VALUES (?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);

ps.setDouble(1, amount);
ps.setString(2, description);
ps.setString(3, username);
if (ps.executeUpdate()>0){
	return true;}
}
catch (SQLException | ClassNotFoundException sqinit) {
//	log.error("Catch block: Initialize Claim");
sqinit.printStackTrace();}
	return false;
}







/*
@Override
public boolean setEmployee (Employee employee) {
	Connection conn = cu.getConnection();
//	log.info("Attempt to register an Employee");
try
//	(Connection conn = ConnectUtil.getConnection() )
	{
String sql = "Insert into Employee (username, password, firstname, lastname, email) values (?, ?, ?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, employee.getUsername());
ps.setString(2, employee.getPassword());
ps.setString(3, employee.getFirstname());
ps.setString(4, employee.getLastname());
ps.setString(5, employee.getEmail());
if (ps.executeUpdate()>0) {
	return true;
}
}	catch (SQLException sqe) {
//	log.error("Register Employee catch block");
sqe.printStackTrace();
}
return false;
}
*/





@Override
public boolean setEmployee (String username, String password, String firstname, String lastname) {
//	Connection conn = cu.getConnection();
//	log.info("Attempt to register an Employee");
try
	(Connection conn = ConnectUtil.getConnection() )
	{
String sql = "Insert into Employee (username, password, firstname, lastname) values (?, ?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ps.setString(3, firstname);
ps.setString(4, lastname);
if (ps.executeUpdate()>0) {
	return true;
}
}	catch (SQLException | ClassNotFoundException sqe) {
//	log.error("Register Employee catch block");
sqe.printStackTrace();
}
return false;
}


@Override
public boolean setEmployee (String username, String password, String firstname, String lastname, String email) {
//	Connection conn = cu.getConnection();
//	log.info("Attempt to register an Employee");
try
	(Connection conn = ConnectUtil.getConnection() )
	{
String sql = "Insert into Employee (username, password, firstname, lastname, email) values (?, ?, ?, ?, ?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, username);
ps.setString(2, password);
ps.setString(3, firstname);
ps.setString(4, lastname);
ps.setString(5, email);
if (ps.executeUpdate()>0) {
	return true;
}
}	catch (SQLException | ClassNotFoundException sqe) {
//	log.error("Register Employee catch block");
sqe.printStackTrace();
}
return false;
}


@Override
public boolean changeEmail(String username, String email) {

try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql = "UPDATE " + "Employee" +
			" SET email = ? " +
			" WHERE username = ?";

PreparedStatement psmt = conn.prepareStatement(sql);
psmt.setString(1, email);
psmt.setString(2, username);

if (psmt.executeUpdate()>0) {return true;}
} catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}

	return false;
}


@Override
public ArrayList<Claim> getAllClaims(String username) {

	try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql =
	"SELECT * FROM " + "Reimburse" +
			" WHERE employeeID = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			ArrayList <Claim> userClaims = new ArrayList<>();

			while(rs.next()) {
				userClaims.add (new Claim	(
				rs.getInt("claimID"),
				rs.getDouble("amount"),
				rs.getString("description"),
				rs.getString("status"),
				rs.getString("initDate"),
				rs.getString("decisionDate"),
				rs.getString("employeeID")));
			}
System.out.println(userClaims);
			return userClaims;
} catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}

	return null;
}


@Override
public List<Claim> getPendingClaims(String username) {

	try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql =
	"SELECT * FROM " + "Reimburse" +
			" WHERE employeeID = ? and status IS NULL";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			List <Claim> pendingClaims = new ArrayList<>();

			while(rs.next()) {
				pendingClaims.add (new Claim	(
				rs.getInt("claimID"),
				rs.getDouble("amount"),
				rs.getString("description"),
				rs.getString("status"),
				rs.getString("initDate"),
				rs.getString("decisionDate"),
				rs.getString("employeeID")));
			}

			return pendingClaims;
} catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}

	return null;
}


@Override
public List<Claim> getResolvedClaims(String username) {

	try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql =
	"SELECT * FROM " + "Reimburse" +
			" WHERE employeeID=? and status=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, "1");
			ResultSet rs = pstmt.executeQuery(sql);
			List <Claim> pendingClaims = new ArrayList<>();

			while(rs.next()) {
				pendingClaims.add (new Claim	(
				rs.getInt("claimID"),
				rs.getDouble("amount"),
				rs.getString("description"),
				rs.getString("status"),
				rs.getString("initDate"),
				rs.getString("decisionDate"),
				rs.getString("employeeID")));
			}

			return pendingClaims;
} catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}
	return null;
}


@Override
public List<Employee> getEmployeeList() {
	// TODO Auto-generated method stub
	try
	(Connection conn = ConnectUtil.getConnection() )
{

		String sql = "Select * from Employee";
		Statement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
List <Employee> employees = new ArrayList <> ();

while (rs.next()) {
	employees.add(new Employee(
			rs.getString("username"),
			rs.getString("password"),
			rs.getString("firstname"),
			rs.getString("lastname"),
			rs.getString("admin"),
			rs.getString("email")
			));
}	return employees;	}
catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}
	return null;
}


@Override
public List<Claim> getAllClaims() {
	try
	(Connection conn = ConnectUtil.getConnection() )
{
	String sql = "SELECT * FROM Reimburse";
	Statement stmt = conn.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery(sql);

	List <Claim> allClaims = new ArrayList<>();

	while(rs.next()) {
	allClaims.add (new Claim	(
	rs.getInt("claimID"),
	rs.getDouble("amount"),
	rs.getString("description"),
	rs.getString("status"),
	rs.getString("initDate"),
	rs.getString("decisionDate"),
	rs.getString("employeeID")));
	}

	return allClaims;} catch (SQLException | ClassNotFoundException sqe) {sqe.printStackTrace();}
	return null;
}


@Override
public boolean approveClaim(int claimID) {
	try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql = "UPDATE " + "Reimburse" +
			" SET status = ? , decisiondate = ? " +
			" WHERE claimID = ?";

PreparedStatement psmt = conn.prepareStatement(sql);
psmt.setString(1, "1");
psmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
psmt.setInt(3, claimID);

if (psmt.executeUpdate()>0) {return true;}
} catch (SQLException | ClassNotFoundException sqe) {
	System.out.println("approve catch");
	sqe.printStackTrace();}
	return false;
}


@Override
public boolean rejectClaim(int claimID) {
	try
	(Connection conn = ConnectUtil.getConnection() )
	{String sql = "UPDATE " + "Reimburse" +
			" SET status = ? , decisiondate = ? " +
			" WHERE claimID = ?";

PreparedStatement psmt = conn.prepareStatement(sql);
psmt.setString(1, "0");
psmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
psmt.setInt(3, claimID);

if (psmt.executeUpdate()>0) {return true;}
} catch (SQLException | ClassNotFoundException sqe) {
	System.out.println("Catch Block: Reject Claim");
	sqe.printStackTrace();}
	return false;
}

}
