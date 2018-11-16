package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.model.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		Session s = HibernateUtil.getSession();
		List<Bear> bears = s.createQuery("from Bear", Bear.class).list();
		s.close();
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		Session s = HibernateUtil.getSession();
//		String hql = "from Bear where id = :idVar";
//		Query<Bear> q = s.createQuery(hql, Bear.class);
//		q.setParameter("idVar", id);
//		Bear bear = q.getSingleResult();
		Query q = s.getNamedQuery("getByIdQuery");
		q.setParameter("idVar", id);
		Bear bear = (Bear) q.getSingleResult();
		s.close();
		return bear;
	}

	@Override
	public int createBear(Bear b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int bearPk = (int) s.save(b);
		tx.commit();
		s.close();
		return bearPk;
	}

	@Override
	public void updateBear(Bear b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBearById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bear> getBearsByName(String name) {
		Session s = HibernateUtil.getSession();
		String sql = "SELECT * FROM BEAR WHERE BEAR_NAME = ?";
		Query<Bear> q = s.createNativeQuery(sql, Bear.class);
		q.setParameter(1, name);
		List<Bear> bears = q.list();
		return bears;
	}

	@Override
	public List<Bear> getYBears() {
		Session s = HibernateUtil.getSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
		Root<Bear> root = cq.from(Bear.class);
		cq.select(root); //cq.select(root.get("name")); selects name property
		cq.where(cb.like(root.get("name"), "Y%"));
		Query<Bear> q = s.createQuery(cq);
		List<Bear> bears = q.list();
		s.close();
		return bears;
	}

	@Override
	public long getBearCount() {
		Session s = HibernateUtil.getSession();
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Bear> root = cq.from(Bear.class);
		cq.select(cb.count(root));
		Query<Long> q = s.createQuery(cq);
		Long count = q.getSingleResult();
		s.close();
		return count;
	}

}
