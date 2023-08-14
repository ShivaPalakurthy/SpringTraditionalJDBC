package com.springcoretradionalJDBC.service;

import java.util.List;

import com.springcoretradionalJDBC.Model.Admin;
import com.springcoretradionalJDBC.dao.AdminDAO;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao;
	public void setDao(AdminDAO dao) {
		this.dao=dao;
	}
	
	AdminServiceImpl() throws Exception {
		System.out.println("Service Initialized");
	}
 
	@Override
	public int addservie(Admin ad) { 
		int i=dao.add(ad);
		return i;
	}

	@Override
	public int updateservie(Admin ad) { 
		int i =dao.update(ad);
		return 0;
	}

	@Override
	public int deleteservice(int id) {
		int i=dao.delete(id);
		return i;
	}

	@Override
	public Admin getAdminserviceById(int id) {
		Admin i=dao.getAdminById(id);
		return i;
	}
	@Override
	public List<Admin> getAllAdmin() {
		return dao.getAllAdmin();
		 
	}
}
