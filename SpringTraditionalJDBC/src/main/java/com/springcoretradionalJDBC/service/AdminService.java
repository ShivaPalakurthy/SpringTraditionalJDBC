package com.springcoretradionalJDBC.service;

import java.util.List;
import com.springcoretradionalJDBC.Model.Admin;

public interface AdminService {
	public int addservie(Admin ad);
	public int updateservie(Admin ad);
	public int deleteservice(int id);
	public List<Admin> getAllAdmin();
	public Admin getAdminserviceById(int id);
}
