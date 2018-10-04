package com.springmvc.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UsuarioDao;
import com.springmvc.pojo.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(Usuario usuario ) {
		
		usuario.setFechaCreacion(new Timestamp(new Date().getTime()));
		//Encriptar password del usuario
		String ClaveUsr = usuario.getClave();
		usuario.setClave(passwordEncoder.encode(ClaveUsr));
		usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {
		
		return usuarioDao.findAll();
	}

}
