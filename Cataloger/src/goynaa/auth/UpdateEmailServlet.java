package goynaa.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Get the parameter from the front end
		//old email and the new email
		String current_email = req.getParameter("current_email");
		String updated_email = req.getParameter("updated_email");
		System.out.println("current_email is: "+current_email);
		System.out.println("updated_email is: "+updated_email);			
		//first check is to see if the old email exist and the new email exist
		//there are chances:
		//PROPER Request
		//1.If the old email exist and the new email do not exist, proper request to update email address
		//IMPROPER Request
		//2.If both, the old email and the new email also exist, this is a improper request, let the user know that and use one of them to log in.If forgot password, request a new password.
		//3.If the old email do not exist and the new email exist, this is a improper request. Let the user know they can log in using the email to login or properly change the update email 
		UpdateEmail updateEmail = new UpdateEmail();
		//String update_email_status = updateEmail.updateEmail(current_email, updated_email);
		//System.out.println(update_email_status);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
