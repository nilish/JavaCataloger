package goynaa.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class ProductCountPOJO {

	Connection connection = new DBConnection().connect();
			
	
	public int countProduct() throws SQLException{
    	int count = 0;
   
    	if (connection != null) {
    		//return "You made it, take control your database now!";
    		Statement st = connection.createStatement();
			String query = "SELECT COUNT(product_id) FROM product";
			ResultSet result_set = st.executeQuery(query);
			if(result_set.next()){
				count = result_set.getInt("COUNT(product_id)");
				System.out.println(count);
			}
			// show that the new account has been created
			
			  st.close();
			 // connection.close();
		
    	}
		return count;
	}
}
