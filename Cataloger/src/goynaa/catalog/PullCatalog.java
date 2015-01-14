package goynaa.catalog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class PullCatalog {

	public List<Row> viewCatalog(String choice, String choice_name) {
		
		List<Row> rows = new ArrayList<Row>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			 String query = "select * from inventory, product, product_image, placements  where placements.product_id=product.product_id and inventory.product_id=product.product_id and product_image.product_id=product.product_id;";
		      connection = new DBConnection().connect();
		      statement = connection.prepareStatement(query);
		      resultSet = statement.executeQuery();
		    
		      while(resultSet.next()){
		    	  Row row = new Row();
		    	  
		    	  row.setProduct_id(Integer.parseInt(resultSet.getString("product_id")));
		    	  row.setImage_name(resultSet.getString("image_name"));
		    	  row.setProduct_unit_price(resultSet.getFloat("product_unit_price"));
		    	  row.setProduct_title(resultSet.getString("product_title"));
		    	  rows.add(row);
		    	  
		      }
		}catch(Exception e){
	             	e.printStackTrace();	
		}
		return rows;
	}
	
	
	public List<Row> viewProductList() {
		
		List<Row> rows = new ArrayList<Row>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			 String query = "select * from product";
		      connection = new DBConnection().connect();
		      statement = connection.prepareStatement(query);
		      resultSet = statement.executeQuery();
		      while(resultSet.next()){
		    	  Row row = new Row();
		    	  row.setProduct_id(Integer.parseInt(resultSet.getString("product_id")));
		    	 row.setProduct_title(resultSet.getString("product_title"));
		    	  row.setProduct_description(resultSet.getString("product_description"));
		    	//  row.setProduct_title(resultSet.getString("description_tag"));
		    	  rows.add(row);
		      }
		}catch(Exception e){
	             	e.printStackTrace();	
		}
		return rows;
	}
	
	
	
}
