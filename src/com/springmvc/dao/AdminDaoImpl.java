package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.Admin;



@Transactional
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Admin admin) {
		
		getSession().save(admin);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> findall() {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		Query query = getSession().createQuery("from Admin");
		return query.list();
	}

	@Override
	public Admin findById(int id) {
		
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Admin.class);
		crit.add(Restrictions.eq("idAd", id));
		
		return (Admin) crit.uniqueResult();
		
	}

	
//	@Override
//	public List<Admin> findByNombre(String nombre) {
//		
//		@SuppressWarnings("deprecation")
//		Criteria crit = getSession().createCriteria(Admin.class);
//		
//		crit.add(Restrictions.like("nombre", "%" + nombre + "%"));
//		
//		return crit.list();
//	}
	@Override
	public List<Admin> findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(Admin.class);
		
		crit.add(Restrictions.like("nombre", "%" + nombre + "%"));
		
		return crit.list();
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		getSession().update(admin);
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		getSession().delete(admin);
		
	}
	
}