package com.springcoretradionalJDBC.dao;

import java.util.List;

import com.springcoretradionalJDBC.Model.Admin;
 

public interface AdminDAO {   
	public int add(Admin ad);
	public int update(Admin ad);
	public int delete(int id);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	
}
