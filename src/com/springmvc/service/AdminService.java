package com.springmvc.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.AdminDao;
import com.springmvc.pojo.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public void save(Admin admin){
		
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		 adminDao.save(admin);
		
	}

	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminDao.findall();
	}

	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return adminDao.findById(id);
	}
	
	public void saveOrUpdate(Admin admin) {
		if (admin.getIdAd() == 0) {
			// Insert
			admin.setFechaCreacion(new Timestamp(new Date().getTime()));
			 adminDao.save(admin);
		}
		else{
			// Update
			 adminDao.update(admin);
		}
	}

	public void delete(int id) {
		Admin admin = adminDao.findById(id);
		adminDao.delete(admin);
	}

//	public List<Admin> findAllLikeNombre(String nombreAdmin) {
//		// TODO Auto-generated method stub
//		return adminDao.findByNombre(nombreAdmin);
//	}
	public List<Admin> findAllLikeNombre(String nombreAdmin) {
		return adminDao.findByNombre(nombreAdmin);
	}

}
