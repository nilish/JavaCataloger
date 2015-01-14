package goynaa.auth;

import java.sql.SQLException;

public class UpdateEmail {

	public String updateEmail(String current_email, String updated_email) throws SQLException {
		// TODO Auto-generated method stub
		String result = null;
		
		
		boolean verify_current_email = false;
		boolean verify_updated_email = false;
		String email_send_status_code = null;	
		
			System.out.println("verifying current and new update email");
			verify_current_email = new AuthenticateUser().verifyEmail(current_email);
			//verify_updated_email = new AuthenticateUser().verifyEmail(updated_email);
		
		//Check for proper Request
		//if current email exisit ad the update email do not exist
		
		if(verify_current_email == true){
			
			//check if the update email exist
			
			verify_updated_email = new AuthenticateUser().verifyEmail(updated_email);
			if(verify_updated_email == false){ 
			//that means this email do no exist. So this can be added as the updated email of the user
			//insert the email into the database with new entry and 
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}

}
