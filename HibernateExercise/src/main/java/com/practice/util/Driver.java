package com.practice.util;

import org.hibernate.Session;

import com.practice.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		
		s.close();
	}

}