package com.dipak.hostelmgmtsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class DatabaseCreate {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="create database hostel";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","dipak");
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("databse created");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
finally {
	try {
		ps.close();
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	}

}
