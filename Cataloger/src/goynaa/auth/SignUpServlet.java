package goynaa.auth;

import goynaa.registration.CreateLoginAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class SignUpServlet extends HttpServlet{

	//this servlet collects the email and the password entered by the new cataloger user and 
	//save into the database
	//what are the scenerio
	//a complete new user
	//an existing user with the email
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String new_email = req.getParameter("new_email");
		String new_password = req.getParameter("new_password");
		//String new_account_name = req.getParameter("new_account_name");
		
		//System.out.println("A new catalog user is request account");
		//System.out.println("The person's email is " +new_email);
		//System.out.println("The persona name or business name is " +new_account_name);
	    //System.out.println("The password is "+ new_password);
		
		
		//consudering the validation has already been done in the javascript side
		//move to check if the email is in the DB
		
		
			CreateLoginAccount newLogin = new CreateLoginAccount();
			int response_code = 0;
			try {
				response_code = newLogin.insertNewLogin(new_email, new_password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(response_code);	 
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
}
