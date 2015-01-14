package goynaa.catalog;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
			Connection connection = null;
			String db_url = "jdbc:mysql://localhost:3306/goynaa_db";
			String db_username = "root";
			String db_password = "";
			String db_driver_name = "com.mysql.jdbc.Driver";
			
	public Connection connect(){
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		System.out.println("Where is your MySQL JDBC Driver?");
    		e.printStackTrace();
    	}
    	System.out.println("MySQL JDBC Driver Registered!");
    	         connection = null;
    	try {
    		connection = DriverManager.getConnection(db_url,db_username,db_password);  
    	} catch (SQLException e) {
    		System.out.println("Connection Failed! Check output console");
    		e.printStackTrace();
    	}
    	return connection;
	
	}

}
