package goynaa.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class CopyOfProductImageUpload extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
		String[] images = null;
		List<String> image_names = new ArrayList<String>();
		
		
		//we will get the product id form the request.getParameter()
		//String product_id = req.getParameter("product_id");
		//System.out.println("value of profuct_id from req.getParameter()"+product_id);
		
		if(isMultiPart){
			ServletFileUpload upload = new ServletFileUpload();
			int product_id = 0;
			
			try{
				FileItemIterator itr = upload.getItemIterator(req);
				while(itr.hasNext()){
				FileItemStream item = itr.next();
				
				if(item.isFormField() && item.getFieldName() == "product_id"){
					//do form specific stuff
					String fieldName = item.getFieldName();
					InputStream is = item.openStream();
					byte[] b = new byte[is.available()];
					is.read(b);
					String value = new String(b);
					System.out.println("FieldName is :="+fieldName);
					System.out.println("String valeu of value:=" +value);
					//System.out.println("Int value of value:="+Integer.parseInt(value));
					
					if((value != null) && (fieldName.equals("product_id"))){
					   product_id = Integer.parseInt(value);
				
					} 
					resp.getWriter().println(fieldName+":"+value+"<br/>");
					
					
					
				}
				 
				
				//do file upload	
					String image_name = item.getName();
					System.out.println(image_name);
					//String path = getServletContext().getRealPath("/");
					String path = "/Users/rumana/Pictures/goynaa/images/product";
					//call a method to upload the file
					FileUpload fu = new FileUpload();
					if(fu.processFile(path, item)){
						//System.out.println(path);	
					resp.getWriter().println("file uploaded successfully");
					image_names.add(image_name);
					System.out.println("image_name :" +image_name);
					images = image_names.toArray(new String[image_names.size()]);
					
					
					   AddProduct ap = new AddProduct();
						//convert the product_id into int
						//int product_id_int = 0;
						//if(product_id != null){
						//	product_id_int = Integer.parseInt(product_id);
							
						//}
					   
					   
						//System.out.println("value of porduct_id_int"+product_id_int);
						
						System.out.println("product_id :" +product_id);
						System.out.println("images :" +images);
						try {
							ap.addProductImage(product_id, images);
						} catch (SQLException e) {
						//	 TODO Auto-generated catch block
						e.printStackTrace();
						}
					
					
					
						resp.getWriter().println("file uload unsuccessful");
						
					
				}
				
				
				
				}
				
			} catch(FileUploadException f){	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {                     
		// TODO Auto-generated method stub
		doGet(req, resp);
		
        }
	}