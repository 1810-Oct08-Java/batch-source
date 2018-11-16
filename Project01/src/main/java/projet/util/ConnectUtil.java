package projet.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;



public final class ConnectUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        String url = "jdbc:oracle:thin:@mydb.c91c1tycuwff.us-east-1.rds.amazonaws.com:1521:ORCL";
        String user = "root";
        String pass= "abc123ume";
        
        return DriverManager.getConnection(url, user, pass);
    }
}





/*
public class ConnectUtil {

private static ConnectUtil connUtil = null;
private static Properties prop = new Properties();

private ConnectUtil () {
	super();
InputStream dbProp = ConnectUtil.class.getClassLoader().getResourceAsStream
		("database.properties");
try {	prop.load(dbProp);	}
catch (IOException ioe) {	ioe.printStackTrace();	}
}

public static ConnectUtil getInstance () {
	if (connUtil==null) {	connUtil = new ConnectUtil();	}
	return connUtil;
}

public Connection getConnection () {
Connection conn = null;

System.out.println(prop.getProperty("password"));

try {
Class.forName(prop.getProperty("driver"));
conn = DriverManager.getConnection(
	prop.getProperty("url"),
	prop.getProperty("user"),
	prop.getProperty("password"));

System.out.println(prop.getProperty("password"));

	} catch (Exception e) {	e.printStackTrace();	}
return conn;
}

}
*/