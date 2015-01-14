package goynaa.auth;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * this servlet is in charge of authenticating admin user and see if they are already register to log into the admin portal
 */

public class AdminLogin extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			
			{
		HttpSession session = req.getSession(true);
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		Date login_time = new java.util.Date();
		
		
		//these has already been validatedin the front tier for format, robot entry etc.
		//there will be a check to to see if these are valid username and password
		//if they are 
		
		AuthenticateUser au = new AuthenticateUser();//Question - should design pattern beused design pattern
		boolean auth = false;
		try {
			auth = au.authenticateUser(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("boolean value from autheticateUser method %s", auth);
		//boolean result = true;
		if(auth == true)
		{
			//redirect the user to the 
			//System.out.printf("the user %s is authenticated and grant access", email);
			session.setAttribute("logged-in", true);
			session.setAttribute("cataloger_email", email);
			session.setAttribute("login_time", login_time);
			//req.getRequestDispatcher("/admin_dashboard.jsp").forward(req, resp);
		    resp.sendRedirect("./admin_dashboard.jsp");
		}
		
		else if (auth == false){
		    //return to the login page
			//System.out.println("no check");
			resp.sendRedirect("cataloger.jsp");
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doGet(req, resp);
		
		
	}
	
	
	
	
	
}
