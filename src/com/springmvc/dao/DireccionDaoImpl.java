package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.Direccion;



@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion direccion) {
		// TODO Auto-generated method stub
		getSession().save(direccion);
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Direccion> findAll(Admin admin) {
		Criteria crit = getSession().createCriteria(Direccion.class)
				.setFetchMode("admin", FetchMode.JOIN)
				.add(Restrictions.eq("admin.idAd", admin.getIdAd()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return crit.list();
	}


	
	
}