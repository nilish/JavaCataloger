package goynaa.admin;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


public class AddProduct extends HttpServlet{
	
    Connection connection = new DBConnection().connect();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");
		/*
		 * product id	
		 */
		int productId = 0;
		try {
			ProductCountPOJO pcp = new ProductCountPOJO();
			//Count the current product number	and add 1
			productId = pcp.countProduct() + 1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * product title
		 */
		String productTitle = req.getParameter("product_title");
		/*
		 * product description
		 */
		String productDescription = req.getParameter("product_description");
		/*
		 * product measurement
		 */
				double product_weight;
				double product_length;
				double product_width;
				String weight = req.getParameter("product_weight");
				String length = req.getParameter("product_length");
				String width = req.getParameter("product_width");
				if(weight != null){
					product_weight = Double.parseDouble(weight);
				}
				if(length != null){
					product_length = Double.parseDouble(length);
				}
				if(width != null){
					product_width = Double.parseDouble(width);
				}
		
	
		
		/*
		 * Multiple values product properties
		 * colors, shapes, placements, types, styles, sizes
		 */
		String[] colors = req.getParameterValues("product_color");
		String[] shapes = req.getParameterValues("shape");
		String[] placements = req.getParameterValues("placement");
		String[] types = req.getParameterValues("type");
		String[] styles = req.getParameterValues("style");
		String[] sizes = req.getParameterValues("size");
		String[] stones = req.getParameterValues("stone");
		String[] baseMaterials = req.getParameterValues("base_material");
		
		
		
		try {
			createNewProduct(productId,productTitle,productDescription);
			addProductColors(productId,colors);
			addProductShapes(productId, shapes);
			addProductBaseMaterial(productId, baseMaterials);
			addProductStone(productId, stones);
			addProductPlacement(productId, placements);
			addProductStyle(productId, styles);
			addProductSize(productId, sizes);
			addProductType(productId, types);
			connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		String [] catagory;String [] material_metal;String [] material_stone;String [] material_non_metal;
		String [] design;String size;String shape;String[] color;
		String supplier;String description;String country_origin;String body_piece;String image_path;
		*/	
		
		//send to the product image upload page with the product_id
		resp.sendRedirect(req.getContextPath() + "/image_upload.jsp?product_id="+productId);
	}			
public void createNewProduct(int pro_id, String pro_title, String pro_descrp) throws SQLException{	
    	if (connection != null) {
    		//System.out.println("You made it, take control your database now!");
			String query_insert_product = "INSERT INTO product" +  "(product_id, product_title,product_description)"+ "VALUES (?,?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product);
			pst.setInt(1, pro_id);
			pst.setString(2, pro_title);
			pst.setString(3, pro_descrp);
		    //Knowledge: int numRowsChanged = pst.executeUpdate(query);//http://stackoverflow.com/questions/7574134/jdbc-returning-mysqlsyntaxerror-exception-with-correct-statement
			int numRowsChanged = pst.executeUpdate();			
			// show that the new account has been createds
			System.out.println("Row changed : "+numRowsChanged);
			System.out.println("Successfully insert the product id "+pro_id);
			pst.close();
    	}
}
    	public void addProductColors(int product_id, String[] colors_p) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_color = "INSERT INTO colors" + "(product_id, product_color)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_color);			
			for(String color_name:colors_p){
				pst.setInt(1, product_id);
				pst.setString(2, color_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}	
    	public void addProductShapes(int product_id, String[] shapes_p) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_shape = "INSERT INTO shapes" + "(product_id, product_shape)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_shape);			
			for(String shape_name:shapes_p){
				pst.setInt(1, product_id);
				pst.setString(2, shape_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
    	
    	public void addProductBaseMaterial(int product_id, String[] base_material) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_base_material = "INSERT INTO base_material" + "(product_id, base_material)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_base_material);			
			for(String base_material_name:base_material){
				pst.setInt(1, product_id);
				pst.setString(2, base_material_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
    	
     	public void addProductStone(int product_id, String[] stones) throws SQLException{
        	if (connection != null) {
        	//	System.out.println("You made it, take control your database now!");
			String query_insert_product_stones = "INSERT INTO stones" + "(product_id, stone_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_stones);
			if(stones != null){
			for(String stone_name: stones){
				pst.setInt(1, product_id);
				pst.setString(2, stone_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			}
			pst.close();
        	}
    	}
     	
     	
       	public void addProductPlacement(int product_id, String[] placements) throws SQLException{
        	if (connection != null) {
        	//	System.out.println("You made it, take control your database now!");
			String query_insert_product_placement = "INSERT INTO placements" + "(product_id, placement_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_placement);			
			for(String placement_name: placements){
				pst.setInt(1, product_id);
				pst.setString(2, placement_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
       	
       	
     	public void addProductStyle(int product_id, String[] styles) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_style = "INSERT INTO styles" + "(product_id, style_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_style);			
			for(String style_name: styles){
				pst.setInt(1, product_id);
				pst.setString(2, style_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
       	
       	
    	
    	public void addProductSize(int product_id, String[] sizes) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_size = "INSERT INTO sizes" + "(product_id, size_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_size);			
			for(String size_name: sizes){
				pst.setInt(1, product_id);
				pst.setString(2, size_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
    	
    	public void addProductType(int product_id, String[] types) throws SQLException{
        	if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
			String query_insert_product_type = "INSERT INTO type" + "(product_id, type_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_type);			
			for(String type_name: types){
				pst.setInt(1, product_id);
				pst.setString(2, type_name);
				int numRowsChanged = pst.executeUpdate();	
			}
			pst.close();
        	}
    	}
    	
    	
    	
    	public void addProductImage(int product_id , String[] images) throws SQLException {
    		
    		/*
    		 * Adding product image has two steps
    		 * Step 1 : Create the entries in the database
    		 * Step 2: Upload the images in the 
    		 */
    		if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
        		//INSERT INTO images" + "(product_id, image_name)"+"VALUES (?,?)
        		//new create statement
			String query_insert_product_image = "INSERT INTO product_image" + "(product_id, image_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_image);
			int len = images.length;
			System.out.println("number of image = "+len);
			
			for(int i = 0 ; i < len ; i++){ 
				String image_name = images[i];
				pst.setInt(1, product_id );
				pst.setString(2, image_name);
				int numRowsChanged = pst.executeUpdate();
				System.out.println(numRowsChanged);
			}
			pst.close();
			
        	}
    		
    		
    		
    	}
       	
    	
    	
public void addProductCampaignImage(int product_id , String image_name) throws SQLException {
    		
    		/*
    		 * Adding product image has two steps
    		 * Step 1 : Create the entries in the database
    		 * Step 2: Upload the images in the 
    		 */
    		if (connection != null) {
        		//System.out.println("You made it, take control your database now!");
        		//INSERT INTO images" + "(product_id, image_name)"+"VALUES (?,?)
        		//new create statement
			
    			String query_insert_product_image = "INSERT INTO product_image_frontpage" + "(product_id, image_name)"+"VALUES (?,?)";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query_insert_product_image);
			
			
				pst.setInt(1, product_id );
				pst.setString(2, image_name);
				int numRowsChanged = pst.executeUpdate();
				System.out.println(numRowsChanged);
			
			pst.close();
			
        	}
    		
    		
    		
    	}
    	
    	
    	
    	
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
