package com.revature.util;

import java.util.List;

import com.revature.dao.BearDao;
import com.revature.dao.BearDaoImpl;
import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.model.Bear;
import com.revature.model.Cave;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
		/*
		CaveDao cd = new CaveDaoImpl();
		
		Cave c1 = new Cave("Luray Caverns");
		Cave c2 = new Cave("Dixie Caverns");
		Cave c3 = new Cave("Bat Cave");
		
		cd.createCave(c1);
		cd.createCave(c2);
		cd.createCave(c3);
		
		BearDao bd = new BearDaoImpl();
		Bear b1 = new Bear("Yogi",Date.valueOf("1950-02-08"),c1);
		Bear b2 = new Bear("Smokey", Date.valueOf("1934-06-10"),c2);
		Bear b3 = new Bear("Ted", Date.valueOf("1999-02-11"),c2);
		
		bd.createBear(b1);
		bd.createBear(b2);
		bd.createBear(b3);
		*/
//		
//		cd.deleteCaveById(3);
//		cd.deleteCaveById(2);
//		
		
//		CaveDao cd = new CaveDaoImpl();
//		List<Cave> caves = cd.getCaves();
//		for(Cave c : caves) {
//			System.out.println(c);
//		}
		
//		System.out.println(cd.getCaveById(5));

		BearDao bd = new BearDaoImpl();
//		List<Bear> bears = bd.getBears();
//		for(Bear b : bears) {
//			System.out.println(b);
//		}
		System.out.println(bd.getBearById(21));
		
//		System.out.println(bd.getBearsByName("Yogi"));
		
		
//		System.out.println(bd.getYBears());
//		System.out.println(bd.getBearCount());
	}

}
