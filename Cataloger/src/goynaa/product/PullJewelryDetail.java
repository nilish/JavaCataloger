package goynaa.product;


import goynaa.catalog.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class PullJewelryDetail {
	
	Connection connection = new DBConnection().connect();


	public Product viewJewelryDetail(String product_id) {
		ResultSet resultSet = null;
		Jewelry row = null;
		try {
			//Get the Specific product details about the particular product
			ArrayList<String> colors = getProductColors(product_id);
			ArrayList<String> images = getProductImages(product_id);
			ArrayList<String> materials = getProductMaterials(product_id);
			String weight = getProductWeight(product_id);
			String size= getProductWeight(product_id);
			String length = getProductLength(product_id);
			String width = getProductWidth(product_id);
			String title = getProductTitle(product_id);
			String description = getProductDescription(product_id);
			String type = getProductType(product_id);
			String placement = getProductPlacement(product_id);
			String campaign_image = getProductCampaignImage(product_id);
			
			
			row = new Jewelry();
			
			if(colors != null){
				row.setColors(colors);
			}
			
			if(materials != null){
				row.setBase_materials(materials);
			}
			
			if(images != null){
			   row.setImages(images);	
			}
			
			if(title != null){
				row.setProduct_title(title);
			}
			
			if(description != null){
				row.setProduct_description(description);
			}
			
			if(campaign_image !=null){
				System.out.println("campaign_image is :"+campaign_image);
				row.setCampaign_image(campaign_image);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
		
	}
	
	private String getProductPlacement(String product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getProductType(String product_id) {
		String type = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_type = "select type.type_name from type where product_id="+product_id;
	    	 statement = connection.prepareStatement(query_type);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 type = resultSet.getString("type_name");
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return type;
	}

	private String getProductDescription(String product_id) {
		// TODO Auto-generated method stub
		String description = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_description = "select product.product_description from product where product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_description);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 description = resultSet.getString("product_description");
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return description;
	}

	private String getProductTitle(String product_id) {
		String title = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	     try
	     {
	    	 String query_title = "select product.product_title from product where product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_title);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 title = resultSet.getString("product_title");
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return title;
	}

	public String getProductSize(String product_id){
		String size = null;
		PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_size = "select product.product_id, sizes.size_name from product,sizes where product.product_id = sizes.product_id and product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_size);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 size = resultSet.getString("product_size");
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return size;
		
	}
	
	private String getProductLength(String product_id) {
		// TODO Auto-generated method stub
		String length = null;
		
		
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	     
	     try
	     {
	    	 String query_measurement = "select length from jewelry_measurement where jewelry_measurement.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_measurement);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 length = resultSet.getString("length");
				 
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	
		
		return length;
	}

	private String getProductWeight(String product_id) {
		// TODO Auto-generated method stub
		String weight = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	     
	     try
	     {
	    	 String query_measurement = "select weight from jewelry_measurement where jewelry_measurement.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_measurement);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 weight = resultSet.getString("weight");
				 
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
		
	
		
		return weight;
	}
	
	private String getProductWidth(String product_id) {
	 
		String width = null;
		PreparedStatement statement = null;
	    ResultSet resultSet = null;
	     
	     try
	     {
	    	 String query_measurement = "select width from jewelry_measurement where jewelry_measurement.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_measurement);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 width = resultSet.getString("width");
				 
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
		
		return width;

	}
	
	/*
	 * This method will get the three measurement in a hashmap 
	 */
	private HashMap getProductMeasurement(String product_id){
		HashMap<String, Double> measurement = new HashMap<String, Double>();
		PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     
	     double width = 0;
	     double length = 0;
	     double weight = 0;
	     try
	     {
	    	 String query_measurement = "select * from jewelry_measurement where jewelry_measurement.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_measurement);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 width = resultSet.getDouble("width");
				 length = resultSet.getDouble("length");
				 weight = resultSet.getDouble("weight");
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	     
	    //Insert the measurements into the hash map
	     
	     measurement.put("weight", weight);
	     measurement.put("length", length);
	     measurement.put("width", width);
		
		
		return measurement;
		
	}

	public ArrayList<String> getProductColors(String product_id){
		//Object[] colors;
	     ArrayList<String> colors_list = new ArrayList<String>();;
	     String color = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     
		try
	     {
	    	 String query_color = "select product.product_id, colors.product_color from product,colors where product.product_id=colors.product_id and product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_color);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 color = new String(resultSet.getString("product_color"));
				 colors_list.add(color);
				 
			 }
			 
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
		
		return colors_list;
	     
		
	}
	
	public ArrayList<String> getProductImages(String product_id){
		ArrayList<String> product_images = new ArrayList<String>();
		String image;
	     String[] images = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_image = "select product.product_id, product_image.image_name from product,product_image where product.product_id=product_image.product_id and product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_image);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 image = resultSet.getString("image_name");
				 product_images.add(image);
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	    // images = (String[])product_images.toArray();
	     return product_images;
	}
	
	public String getProductCampaignImage(String product_id){
		//String product_campaign_image;
		String image = null;
	     //String[] images = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_image = "select product.product_id, product_campaign_image.image_name from product,product_campaign_image where product.product_id=product_campaign_image.product_id and product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_image);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 image = resultSet.getString("image_name");
				 System.out.println(image);
				 //product_images.add(image);
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     
	    // images = (String[])product_images.toArray();
	     return image;
	}
	
	public ArrayList<String> getProductMaterials(String product_id){
		ArrayList<String> product_materials = new ArrayList<String>();
		String material;
	     String[] materials = null;
	     PreparedStatement statement = null;
	     ResultSet resultSet = null;
	     try
	     {
	    	 String query_image = "select product.product_id, base_material.base_material from product,base_material where product.product_id=base_material.product_id and product.product_id="+product_id;
	    	 statement = connection.prepareStatement(query_image);
			 resultSet = statement.executeQuery();
			 while(resultSet.next()){
				 material = resultSet.getString("base_material");
				 product_materials.add(material);
			 }
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     //materials = (String[])product_materials.toArray();
	     return product_materials;	
	}
}
