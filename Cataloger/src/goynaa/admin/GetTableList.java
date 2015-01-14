package goynaa.admin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GetTableList {
	
Connection connection = new DBConnection().connect();
			
	
	public List<String> getTableList() throws SQLException{
    	List<String>  table_list = new ArrayList<String>();
   
    	if (connection != null) {
    		DatabaseMetaData meta = connection.getMetaData();
    		String[] types = {"TABLE"};
    		//return "You made it, take control your database now!";
			ResultSet result_set = meta.getTables(null, null, "%", types);
			while(result_set.next()){
				//count++;
				String table_name = result_set.getString("TABLE_NAME");
			    table_list.add(table_name);
			}
			// show that the new account has been created
			
			  
			 // connection.close();
		
    	}
	//	System.out.println("number of tables is "+count);
    	return table_list;
	}
	
	
	public static void main(String[] args){
		
		GetTableList gbt = new GetTableList();
		
		try {
			List<String> result = new ArrayList<String>();
			result = gbt.getTableList();
			System.out.println(result.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
