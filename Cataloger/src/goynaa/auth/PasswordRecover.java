package goynaa.auth;

import java.sql.SQLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import goynaa.auth.*;

public class PasswordRecover {

	String email_send_status_code_success="250";
	String email_send_statuc_code_failure="554";
	String smtp_host_provider = "smtp.mail.yahoo.com";
	String host_port = "465";
	String host_username = "goynaa@yahoo.com";
	String host_password = "Formych2013$";
	
	private Properties setEmailProperties(){
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", smtp_host_provider);
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.username", "goynaa@yahoo.com");
		return properties;
	}

	
	
	
	public String sendEmail(String toEmail){
		
		boolean verify_email = false;
		String email_send_status_code = null;	
		try {
			System.out.println("verifying email");
			verify_email = new AuthenticateUser().verifyEmail(toEmail);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		if(verify_email == true)
		{
	    Properties properties = setEmailProperties();
		//Step 2:
		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator(){
			      protected PasswordAuthentication getPasswordAuthentication(){
			    	  return new PasswordAuthentication(host_username, host_password);
			      }
		         }
				);
		session.setDebug(true);
		//Step 3:
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(host_username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject("Password Recovery");
			int alpha_numeric_token = toEmail.hashCode();//sample
			System.out.println(alpha_numeric_token);
			message.setText("Please click on the following link to reset your password\n"+"http://www.goynaa.com/goynaa/passwordreset?token="+alpha_numeric_token);
			//message.setText("http://www.goynaa.com/goynaa/passwordreset?token="+alpha_numeric_token);
			Transport.send(message);
			System.out.println("Message was sent successfully");
			email_send_status_code = "success";
		} catch (MessagingException e) {
			email_send_status_code = "failure";
			e.printStackTrace();
			
		}
		
		} else {
			
			System.out.println("no record exist for email :"+toEmail);
			email_send_status_code = "unregistered";
		}
		
	
		return email_send_status_code;
	
	}
}
