package goynaa.product;

import goynaa.catalog.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductInventoryDetailDAO {

	Connection connection = new DBConnection().connect();
	
     public Date getProductAddingDate(int product_id){
        Date product_added_date = null; 
    	PreparedStatement statement = null;
 		ResultSet resultSet = null;
 		try{
 			String query = "select date_added from inventory where product_id="+product_id;
 		statement = connection.prepareStatement(query);
 		resultSet = statement.executeQuery();
 		 while(resultSet.next()){
 			 product_added_date = resultSet.getDate("product_added");//see if this works with mysql date 
 			 System.out.println("product added date is :"+product_added_date);
 		 }
      }catch(Exception e){
     	 e.printStackTrace();
      }
    	 return product_added_date;
     }
     
     
     public double getProductUnitPrice(String product_id){
    	double product_unit_price = 0.0; 
    	PreparedStatement statement = null;
 		ResultSet resultSet = null;
 		try{
 			String query = "select  product_unit_price from inventory where product_id="+product_id;
 		statement = connection.prepareStatement(query);
 		resultSet = statement.executeQuery();
 		 while(resultSet.next()){
 			 product_unit_price = resultSet.getDouble("product_unit_price");//see if this works with mysql date 
 			 System.out.println("product unit price is :"+product_unit_price);
 		 }
      }catch(Exception e){
     	 e.printStackTrace();
      } 	 
    	 return product_unit_price;
     }
     
     
     public int getProductInventoryQuantity(int product_id){
    	int product_inventory_quantity = 0;
    	PreparedStatement statement = null;
  		ResultSet resultSet = null;
  		try{
  			String query = "select product_quantity from inventory where product_id="+product_id;
  		statement = connection.prepareStatement(query);
  		resultSet = statement.executeQuery();
  		 while(resultSet.next()){
  			 product_inventory_quantity = resultSet.getInt("product_quantity");//see if this works with mysql date 
  			 System.out.println("product inventory quantity is :"+product_inventory_quantity);
  		 }
       }catch(Exception e){
      	 e.printStackTrace();
       }
		return product_inventory_quantity;
     }
     
     public int getProductInventoryID(int product_id){
     	int inventory_id = 0;
     	PreparedStatement statement = null;
   		ResultSet resultSet = null;
   		try{
   			String query = "select inventory_id from inventory where product_id="+product_id;
   		statement = connection.prepareStatement(query);
   		resultSet = statement.executeQuery();
   		 while(resultSet.next()){
   			 inventory_id = resultSet.getInt("inventory_id");//see if this works with mysql date 
   			 System.out.println("product inventory id is :"+inventory_id);
   		 }
        }catch(Exception e){
       	 e.printStackTrace();
        }
 		return inventory_id;
      }
     
	
}
