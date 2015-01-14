package goynaa.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import goynaa.catalog.DBConnection;
import goynaa.catalog.Row;

public class ProductCatalogDetailDAO {
	
	Connection connection = new DBConnection().connect();

	public int checkProductId(String product_id)
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int result = 0;
		try
		{
			String query = "SELECT COUNT(product_id) FROM product WHERE product_id=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, product_id);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				result = resultSet.getInt("COUNT(product_id)");
				System.out.println(result);
			}
		} catch(Exception e){			
			e.printStackTrace();
		}	
		return result; 
	}
	
	public Product getProductDetail(String product_id){
		String product_type = getProductType(product_id);
		Product j = null;
		/*Possible Product Type 
		*Jewelry, Clothings, Shoes, Accesories, Handbag, Decoration
		*/ 
	if(product_type.equals("jewelry"))
		{
		  	System.out.println("code check");
			PullJewelryDetail jewelry_detail = new PullJewelryDetail();
			j = (Jewelry) jewelry_detail.viewJewelryDetail(product_id);	
		}
	if(product_type.equals("clothing"))	
	{
		System.out.println("clothing code check");
		ClothingDetailDAO clothing_detail = new ClothingDetailDAO();
		j = (Clothing) clothing_detail.viewClothingDetail(product_id);	
	}
		return j;
}
	
	public String getProductType(String product_id){
		String productType = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try{
			String query = "select type_name from type where product_id=?";
		statement = connection.prepareStatement(query);
		statement.setString(1, product_id);
		resultSet = statement.executeQuery();
		 while(resultSet.next()){
			 productType = resultSet.getString("type_name");
			 System.out.println("product type is :"+productType);
		 }
     }catch(Exception e){
    	 e.printStackTrace();
     }
		return productType;	
	  }
	}

