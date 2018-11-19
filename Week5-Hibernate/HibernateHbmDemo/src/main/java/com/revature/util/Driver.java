package com.revature.util;

import java.util.List;

import com.revature.dao.CaveDao;
import com.revature.dao.CaveDaoImpl;
import com.revature.model.Cave;

public class Driver {

	public static void main(String[] args) {
//		Session s = HibernateUtil.getSession();
//		s.close();
		
		CaveDao cd = new CaveDaoImpl();
		
		Cave c1 = new Cave("Luray Caverns");
		Cave c2 = new Cave("Dixie Caverns");
		Cave c3 = new Cave("Bat Cave");
		
//		cd.createCave(c1);
//		cd.createCave(c2);
//		cd.createCave(c3);
//		
//		cd.deleteCaveById(3);
//		cd.deleteCaveById(2);
//		
//		List<Cave> caves = cd.getCaves();
//		for(Cave c : caves) {
//			System.out.println(c);
//		}
		
		System.out.println(cd.getCaveById(5));

	}

}
