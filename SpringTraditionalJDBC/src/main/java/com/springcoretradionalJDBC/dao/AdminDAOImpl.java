package com.springcoretradionalJDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

import com.springcoretradionalJDBC.Model.Admin;

public class AdminDAOImpl implements AdminDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	
	AdminDAOImpl() throws SQLException{
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##shivapalakurthy","1234567890");
				 } 
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public int add(Admin ad) {
		sql="INSERT INTO ADMINTABLE VALUES(?,?,?,?)";
		int i=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, ad.getAdminid());
			ps.setString(2, ad.getAdminname());
			ps.setString(3, ad.getAdminmail());
			ps.setString(4, ad.getPass());
		i=ps.executeUpdate();
		}catch(Exception e){
			System.err.println(e);
		}
		return i;
	}

	@Override
	public int update(Admin ad) {
		sql="UPDATE  ADMINTABLE SET ADMINNAME=? , EMAIL=? , PASS=? WHERE ADMIN_ID=? ";
		int i=0;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, ad.getAdminname());
			ps.setString(2, ad.getAdminmail());
			ps.setString(3, ad.getPass());
			ps.setInt(4, ad.getAdminid());
		i=ps.executeUpdate();
	}catch(Exception e){
		System.err.println(e);
	}
	return i;
	}

	@Override
	public int delete(int id) {
		try {
			sql="DELETE FROM ADMINTABLE WHERE ADMIN_ID=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()>=1)
				return 0;
		}
		catch(Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public List<Admin> getAllAdmin() { 
		ArrayList<Admin> adminList=new ArrayList<Admin>();
	try {
		sql="SELECT * FROM ADMINTABLE";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			Admin admin=new Admin();
		}
		return adminList;
	}catch(Exception e){
		System.err.println(e);
	}
	return adminList;
	}

	@Override
	public Admin getAdminById(int id) {
		try {
			sql="SELECT * FROM ADMINTABLE WHERE ADMIN_ID=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			ps=con.prepareStatement(sql);
			if(rs.next()) {
				Admin admin=new Admin();
				return admin;
			}
		}catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

}
