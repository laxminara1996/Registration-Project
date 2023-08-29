package com.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.LoginDao;
@WebServlet("/createOrLoginAccount")
public class LoginServlet extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
	String Email=req.getParameter("Email");
	String Pwd = req.getParameter("Pwd");
	LoginDao loginDao = new LoginDao();
	
		boolean flag = loginDao.getUserData(Email,Pwd);
		String response = null;
		if(flag) {
			resp.sendRedirect("login.html");
		}else {
			response= "login failed";
		}
		PrintWriter pw = resp.getWriter();
		pw.append(response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
}
