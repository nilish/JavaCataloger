package goynaa.auth;

import goynaa.catalog.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthenticateUser {
	
	
	
	Connection connection = new DBConnection().connect();
	
	public boolean authenticateUser(String email, String password) throws SQLException
	{	
		PreparedStatement st = null;
		ResultSet rst = null;
		boolean result = false;
    	String query = "SELECT * from cataloger_user WHERE email=? AND password=?";
    	
    	if(connection != null){
    		st = connection.prepareStatement(query);
    		st.setString(1, email);
    		st.setString(2, password);
            rst = st.executeQuery();
            if(rst.next()){
            	System.out.println("a record found");
            	System.out.println(rst.getString("enabled"));
            	System.out.println(rst.getString("user_role"));	
            	result = true;
            }
            else result = false;
    	}
		return result;
}
	
	public boolean verifyEmail(String email) throws SQLException{
		boolean result = false;
		PreparedStatement st = null;
		ResultSet rst = null;
    	String query = "SELECT * from cataloger_user WHERE email=?";
    	if(connection != null){
    		st = connection.prepareStatement(query);
    		st.setString(1, email);
            rst = st.executeQuery();
            if(rst.next()){
            	System.out.println("a record found for email = " +email);
            	System.out.println(rst.getString("enabled"));
            	System.out.println(rst.getString("user_role"));	
            	result = true;
            }
            else {
            	result = false;
            }
        
	}
    	 return result;
	}


}
