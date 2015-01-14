package goynaa.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PasswordRecoverServlet
 */

@SuppressWarnings("serial")
public class PasswordRecoverServlet extends HttpServlet {

       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email_username = request.getParameter("email");
		System.out.println("Recovery email is : " + email_username);
		
		
		
		
		PasswordRecover password_recover = new PasswordRecover();
		String password_recovery_status_code = password_recover.sendEmail(email_username);
		request.setAttribute("recovery_email", email_username);
        if(password_recovery_status_code.equals("success")){
        	System.out.println("Password Recovery link in email send successfully");
        	request.setAttribute("password_recovery_status", "success");
        	request.getRequestDispatcher("pwresetconfirm.jsp").forward(request, response);
        } if(password_recovery_status_code.equals("failure")){
        	System.out.println("Something wrong in the email sender/server.Password recovery could not be send successfully");
        	request.setAttribute("password_recovery_status", "failure");
        	request.getRequestDispatcher("pwresetconfirm.jsp").forward(request, response);
        } else if(password_recovery_status_code.equals("unregistered")){
        	System.out.println("The email " +email_username+" is not registered. No email send.");
        	request.setAttribute("password_recovery_status", "unregistered");
        	request.getRequestDispatcher("pwresetconfirm.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
