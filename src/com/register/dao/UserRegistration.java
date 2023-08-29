package com.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.register.util.ConnectionFactory;

public class UserRegistration {
private static final  String insert_sql = "insert into userRegistration values(?,?,?,?,?)";
	public boolean saveUser(String fName,String lName,String Email,String Pwd,String Gender) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement(insert_sql);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.setString(3, Email);
		ps.setString(4, Pwd);
		ps.setString(5, Gender);
		int row = ps.executeUpdate();
		System.out.println(row);
		return row>0;
	}
	
}
