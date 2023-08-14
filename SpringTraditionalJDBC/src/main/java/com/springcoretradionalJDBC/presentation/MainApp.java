package com.springcoretradionalJDBC.presentation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcoretradionalJDBC.Model.Admin;
import com.springcoretradionalJDBC.service.AdminService;
 

public class MainApp {
AdminService adminService;
public void setService(AdminService adminService) {
	this.adminService=adminService;
}
int addAdmin(Admin a1) {
	int i=adminService.addservie(a1);
	return i;
}
int updateAdmin(Admin a1) {
	int i=adminService.updateservie(a1);
	return i;
}
int deleteAdmin(int aid) {
	int i=adminService.deleteservice(aid);
	return i;
}

Admin getAdmin(int uid) {
	Admin i=adminService.getAdminserviceById(uid);
	return i;
}

List<Admin> getAll(){
	return adminService.getAllAdmin();
}
public static void main(String args[]) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("Bean.xml");
	System.out.println("Add Admin Details");
	Admin a1=ctx.getBean(Admin.class);
	MainApp amain=ctx.getBean(MainApp.class);
	System.out.println(amain.addAdmin(a1));
}
}
