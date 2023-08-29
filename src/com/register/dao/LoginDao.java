package com.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.register.util.ConnectionFactory;

public class LoginDao {
	private static final String select_query="select*from userRegistration where Email=? and Pwd=?";
	public boolean getUserData(String Email,String Pwd) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement ps = con.prepareStatement(select_query);
         ps.setString(1, Email);
		ps.setString(2, Pwd);
		System.out.println("----loginDao"+ps);
		ResultSet rs = ps.executeQuery();
		if(rs != null) {
			return true;
		}
		return false;
	}
}
