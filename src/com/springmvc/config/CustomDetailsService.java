package com.springmvc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UsuarioDao;
import com.springmvc.pojo.Usuario;


@Service("CustomDetailsService")
public class CustomDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioDao usuarioDao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		Usuario usuario = usuarioDao.findByUsuario(username);
		
		if (usuario != null) {
			authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
			User user = new User(usuario.getUsuario(),usuario.getClave(),authorities);
			return user;
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
	}

}
