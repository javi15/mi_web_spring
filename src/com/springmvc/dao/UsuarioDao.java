package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Usuario;

public interface UsuarioDao {

	public Usuario findByUsuario(String usuario);

	public void save(Usuario usuario);

	public List<Usuario> findAll();
}
