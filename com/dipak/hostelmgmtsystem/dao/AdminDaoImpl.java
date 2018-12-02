package com.dipak.hostelmgmtsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dipak.hostelmgmtsystem.dto.Admin;
import com.dipak.hostelmgmtsystem.util.DbUtil;

public class AdminDaoImpl implements AdminDao{
PreparedStatement ps=null;
Connection con=null;
	@Override
	public int getCreated(Admin admin) {
		String sql="insert into admin(user_name,password,email)values(?,?,?)";
		int created=0;
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,admin.getUserName());
			ps.setString(2,admin.getPassword());
			ps.setString(3,admin.getEmail());
			created=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return created;
		}
	@Override
	public int login(String userName, String password) {
		String sql="select id from admin where user_name=? and password=?";
		int userId=0;
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				userId=rs.getInt("id");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
		return userId;
	}
}
