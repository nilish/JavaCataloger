package goynaa.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class FindUser {	
	//private boolean result;
	Connection connection = null;
	String db_url = "jdbc:mysql://localhost:3306/goynaa_db";
	String db_username = "root";
	String db_password = "wherearewe2012";
	String db_driver_name = "com.mysql.jdbc.Driver";
	//int num_rowws;
	
	//SETUP THE CONNECTION TO THE DATABASE SERVER
	
    public String find_email(String user_n) throws SQLException{
    	
    	String error = "error";
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("Where is your MySQL JDBC Driver?");
    		e.printStackTrace();
    		return error;
    	}
    	
    	System.out.println("MySQL JDBC Driver Registered!");
    	Connection connection = null;
    	try {
    		connection = DriverManager.getConnection(db_url,db_username,db_password);
     
    	} catch (SQLException e) {
    		System.out.println("Connection Failed! Check output console");
    		e.printStackTrace();
    		return error;
    	}
    	
    	String email = "not good";
    	if (connection != null) {
    		//return "You made it, take control your database now!";
    		Statement st = connection.createStatement();
    		
			String query = "SELECT user_email FROM user WHERE user_name="+user_n;
			ResultSet result = st.executeQuery(query);
			while(result.next()){
			email = result.getString("user_email");
			if(email == null){
				email = "email is null";
			}
			}
			
			//num_rowws = result.getRow();			
			return email;
			} else {
    		return "Failed to make connection!";
    	}
  //  return email;
    }
}
    	
    	
    
    	
    	
    	
    	
    

