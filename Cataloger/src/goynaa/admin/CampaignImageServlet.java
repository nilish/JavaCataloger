package goynaa.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class CampaignImageServlet
 */
//@WebServlet(name="CampaignImageServlet")
//@MultipartConfig

public class CampaignImageServlet extends HttpServlet 
{
	String path = "/Users/rumana/Pictures/goynaa/images/product";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//get request content
		//checks if the request has multi part 
		boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
		
		
		//the two value that will be retrieved from the multipart form data request
		
		int product_id = 0;
		
		
		
		if(isMultiPart){
			
			ServletFileUpload upload = new ServletFileUpload();
			
			try{
				//List<FileItem> multiParts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest((RequestContext) req);
				
				FileItemIterator itr = upload.getItemIterator(req);
				
				while(itr.hasNext()){
					FileItemStream item = itr.next();
			         if(item.isFormField()){
			        	 String fieldName = item.getFieldName();
			        	 System.out.println("form field value or name"+fieldName);
			        	 InputStream is = item.openStream();
			        	 byte[] b = new byte[is.available()];
			        	 is.read(b);
			        	 String value = new String(b);
			        	 System.out.println("FieldName is :="+fieldName);
			        	 System.out.println("String valeu of value:=" +value);
			        	 
					if((value != null) && (fieldName.equals("productid"))){
					   product_id = Integer.parseInt(value);	
					   System.out.println("Product id collected from the form submission is = " + product_id);
					}
			   }
			   
			   //do file upload
			   
			         String image_name = item.getName();
			         
			         /*
			          * DEBUG CODE
			          */
			         System.out.println("Current image name is = "+image_name);
			         
			         FileUpload fu = new FileUpload();
			         
			         if(fu.processFile(path, item)){
			        	 
			        	 if(image_name != null){	
			        		 try {
									AddProduct ap = new AddProduct();
									ap.addProductCampaignImage(product_id, image_name);
									
									//req.setAttribute("image_names", image_names);
									req.setAttribute("product_id", product_id);
								} catch (SQLException e) {
								//	 TODO Auto-generated catch block
								e.printStackTrace();
								}
			        	 }
			        	 
			         }
			         
				}
			} catch(Exception e){}
			
			finally{
			  System.out.println("print finallus");	
			}
			}
			
		}
		
		
		
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	}
	
	

}
