package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	String loginSql = "SELECT * FROM EMPLOYEE WHERE ENAME=? AND PASS=?";
	String userExists = "SELECT * FROM EMPLOYEE WHERE ENAME=?";
	String registerSql = "INSERT INTO EMPLOYEE VALUES (?,?);";
	String url = "jdbc:mysql://localhost:3306/employee_database";
	String username = "root";
	String password = "Ani@2310";
	public String verify(String ename, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(loginSql);
			PreparedStatement st1 = con.prepareStatement(userExists);
			st1.setString(1, ename);
			st.setString(1, ename);
			st.setString(2, pass);
			ResultSet rs1 = st1.executeQuery();
			ResultSet rs = st.executeQuery();
			if(rs.next() && rs1.next()) return "true";
			if(rs1.next()) return "Incorrect password";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "User does not exist";
	}
	public String registerEmployee(String ename, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(registerSql);
			PreparedStatement st1 = con.prepareStatement(userExists);
			st1.setString(1, ename);
			st.setString(1, ename);
			st.setString(2, pass);
			ResultSet rs = st1.executeQuery();
			if(rs.next()) {
				return "User already exists";
			}
			st.executeUpdate();
			return "Registration successful";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "Registration unsuccessful";
	}
}
