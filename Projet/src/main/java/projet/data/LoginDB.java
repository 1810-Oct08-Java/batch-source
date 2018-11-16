package projet.data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import projet.model.Employee;
import projet.util.ConnectUtil;

public class LoginDB implements LoginDao {

//private static ConnectUtil conu = ConnectUtil.getInstance();




@Override
public Employee login (String username, String password) {
Employee login = null;

//Connection con = null;
//con = conu.getConnection();

//System.out.println(conu);

// make sure this matches
String sql = "Select * from Employee where username=? and password=?";

System.out.println("username: " + username);
System.out.println("ps: " + password);

try
	(Connection conn = ConnectUtil.getConnection())
	{
//	System.out.println(con);
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, username);
pstmt.setString(2, password);
ResultSet rs = pstmt.executeQuery();

if (rs.next()) {
login = new Employee (
rs.getString("username"),
rs.getString("password"),
rs.getString("firstname"),
rs.getString("lastname"),
rs.getString("admin"),
rs.getString("email")
);}

}	catch (SQLException sqe)	{
//LOGGER!
sqe.printStackTrace();	} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

return login;

}

}
