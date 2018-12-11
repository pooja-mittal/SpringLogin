package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
	
	public int saveInDB(String uName, String pwd) {
		String connection_url = "jdbc:mysql://localhost:3306/spring_mvc?useSSL=false";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int rowEffected = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connection_url, "root", "root");
			prepareStatement = connection.prepareStatement("insert into login values(?,?)");
			prepareStatement.setString(1, uName);
			prepareStatement.setString(2, pwd);
			rowEffected=prepareStatement.executeUpdate();
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowEffected;
	}
	
	public boolean checkUser(String uName, String pwd) {
		String connection_url = "jdbc:mysql://localhost:3306/spring_mvc?useSSL=false";
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connection_url, "root", "root");
			prepareStatement=connection.prepareStatement("select * from login where userName=? and password=?");
			prepareStatement.setString(1, uName);
			prepareStatement.setString(2, pwd);
			ResultSet rs=prepareStatement.executeQuery();
			while(rs.next()) {
				return true;
			}
		}catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
