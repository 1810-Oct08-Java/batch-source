package allo.util;

import org.hibernate.*;

public class Driver {

	public static void main ( String[] args) {
		Session s = HibernateUtil.getSession();
		s.close();
	}

}
 
