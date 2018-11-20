package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Bear;

@Repository
public class BearDaoImpl implements BearDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	//@Transactional //required propagation by default; same as below
	//@Transactional(propagation=Propagation.REQUIRED) 
	@Transactional(propagation=Propagation.MANDATORY)
	public List<Bear> getBears() {
		Session s = sf.getCurrentSession();
		List<Bear> bears = s.createQuery("from Bear").list();
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
