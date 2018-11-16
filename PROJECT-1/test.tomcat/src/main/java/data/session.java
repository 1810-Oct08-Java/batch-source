package data;

import util.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;


import org.apache.log4j.Logger;
import test.tomcat.beans.userandpass;

public class session {
	final static Logger Log = Logger.getLogger(session.class);
	
	public int attemptLogin(userandpass Logincreds) {
		System.out.println(Logincreds.getUsername());
		String sql = "select empid from employee where uname = '" + Logincreds.getUsername() + "' AND pword = '" + Logincreds.getPassword() + "'";
		System.out.println(sql);

		try (Connection conn = ConnectionUtil.getConnection()){
			System.out.println("successs!");
			PreparedStatement stmt = conn.prepareStatement(sql);
			Log.info("checking login");
			ResultSet result = stmt.executeQuery();
			int output = 0;
			while (result.next()) {
				output = result.getInt("EMPID");
			}
			System.out.println("Curent empid = " + output);
			return output;
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid login");
			s.getMessage();
		}
		return 0;
	}
	
	public String genericCall(String sql) {
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			Log.info("Generic Call of DB Success");
			return "success";
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid Generic Call");
			s.getMessage();
		}
		return "error";
	}
	
	public int initActive(String sql) {
		int i =0;
		try (Connection conn = ConnectionUtil.getConnection()){
			Statement stmnt = conn.createStatement();
			i = stmnt.executeUpdate(sql);
			Log.info("Generic Call of DB Success");
			return i;
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid Generic Call for length");
			s.getMessage();
		}
		return 0;
	}
	public String getQuery(String sql) {
		ResultSet result;
		String output = "", temp = "";
		try (Connection conn = ConnectionUtil.getConnection()){
			Statement stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while (result.next())
			{
				output += "Current username: " + result.getString(1);
				output += "\nCurrent password: " + result.getString(2);
				output += "\nCurrent name: " + result.getString(3);
				output += "\nCurrent email: " + result.getString(4);
				output += "\nCurrent phone number: " + result.getString(5);
				temp += result.getString(6);
				if (temp.equals("m"))
					output += "\nYou are a manager";
				else if (temp.equals("e"))
					output += "\nYou are a non managment employee";
				else
					System.out.println(temp);
			}
			Log.info("Generic Call of DB Success");
			return output;
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid Generic Call for length");
			s.getMessage();
		}
		return null;
	}
	public String getQueryR(String sql) {
		ResultSet result;
		String output = "", temp = "";
		try (Connection conn = ConnectionUtil.getConnection()){
			Statement stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);
			while (result.next())
			{
				output += "Reimbursment userid: " + result.getInt(1);
				output += "\nReimbursment amount: " + result.getInt(2);
				temp = result.getString(3);
				if (temp.equals("a"))
					output += "\nReimbursment is approved";
				else if (temp.equals("p"))
					output += "\nReimbursment is pending";
				else 
					output += "\nReimbursment is denied";
			}
			Log.info("Generic Call of DB Success");
			return output;
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid Generic Call for length");
			s.getMessage();
		}
		return null;
	}
	
}
