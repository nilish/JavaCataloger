package goynaa.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class CreateUser {
	
	//private boolean result;
	Connection connection = null;
	String db_url = "jdbc:mysql://localhost:3306/goynaa_db";
	String db_username = "root";
	String db_password = "";
	String db_driver_name = "com.mysql.jdbc.Driver";
	String db_table = "cataloger_user";
	//int num_rowws;
	
	public void newUser(String username, String password, String email, String firstname, String lastname) throws SQLException{
               
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("Where is your MySQL JDBC Driver?");
    		e.printStackTrace();
  //  		return error;
    	}
    	
    	System.out.println("MySQL JDBC Driver Registered!");
    	Connection connection = null;
    	try {
    		connection = DriverManager.getConnection(db_url,db_username,db_password);
     
    	} catch (SQLException e) {
    		System.out.println("Connection Failed! Check output console");
    		e.printStackTrace();
    //		return error;
    	}
    	if (connection != null) {
    		//return "You made it, take control your database now!";
    		Statement st = connection.createStatement();
    		String query = "INSERT INTO cataloger_user" +  "(username, first_name, last_name, email, password)"+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, firstname);
			pst.setString(3, lastname);
			pst.setString(4, email);
			pst.setString(5, password);
		    int numsRowsChanged = pst.executeUpdate();
			System.out.println(numsRowsChanged);			
			  pst.close();
    	}
			  connection.close();
    	} 	
}



