package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.Direccion;

public interface DireccionDao {
	
	public void save(Direccion direccion);
	public List<Direccion> findAll(Admin admin);

}
