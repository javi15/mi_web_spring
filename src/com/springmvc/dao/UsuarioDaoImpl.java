package com.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.pojo.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Usuario findByUsuario(String usuario) {
		
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("usuario", usuario));
		return (Usuario) crit.uniqueResult();
	}

	@Override
	public void save(Usuario usuario) {
		getSession().save(usuario);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		
		return getSession().createQuery("from Usuario").list();
	}
}
