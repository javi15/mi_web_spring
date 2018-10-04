package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Admin;

public interface AdminDao {
	
	public void save(Admin admin);
	public List<Admin> findall();
	public Admin findById(int idAd);
	public List<Admin> findByNombre(String nombre);
	public void update(Admin admin);
	public void delete(Admin admin);
	

}
