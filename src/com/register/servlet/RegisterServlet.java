package com.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.dao.UserRegistration;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		String fName= req.getParameter("fName");
		String lName= req.getParameter("lName");
		String Email= req.getParameter("Email");
		String Pwd= req.getParameter("Pwd");
		String Gender= req.getParameter("Gender");
		System.out.println(fName);
             UserRegistration reg= new UserRegistration();
		      
				boolean flag = reg.saveUser(fName,lName,Email,Pwd,Gender);
				String response = null;
			if(flag) {
				response = "registration success";
			}else {
				response= "registration failed";
			}
			PrintWriter pw = resp.getWriter();
			pw.append(response);
		      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
