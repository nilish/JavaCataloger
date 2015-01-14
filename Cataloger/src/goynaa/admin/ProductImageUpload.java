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

public class ProductImageUpload extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		boolean isMultiPart = ServletFileUpload.isMultipartContent(req);
		String[] images = null;
		List<String> image_names = new ArrayList<String>();
		int product_id = 0;
		//we will get the product id form the request.getParameter()
		//String product_id = req.getParameter("product_id");
		//System.out.println("value of profuct_id from req.getParameter()"+product_id);
		if(isMultiPart){
			ServletFileUpload upload = new ServletFileUpload();
			try{
				FileItemIterator itr = upload.getItemIterator(req);
				while(itr.hasNext()){
				FileItemStream item = itr.next();
				if(item.isFormField()){
					//do form specific stuff
					String fieldName = item.getFieldName();
					InputStream is = item.openStream();
					byte[] b = new byte[is.available()];
					is.read(b);
					String value = new String(b);
					System.out.println("FieldName is :="+fieldName);
					System.out.println("String valeu of value:=" +value);
					if((value != null) && (fieldName.equals("product_id"))){
					   product_id = Integer.parseInt(value);		
					} 
					//resp.getWriter().println(fieldName+":"+value+"<br/>");
				}
				//do file upload		
					String image_name = item.getName();
					System.out.println("Current Image Name is :"+image_name);
					//String path = getServletContext().getRealPath("/");
					String path = "/Users/rumana/Pictures/goynaa/images/product";
					//call a method to upload the file
					FileUpload fu = new FileUpload();
					if(fu.processFile(path, item))
					{
					if(image_name != null){	
					image_names.add(image_name);
					images = image_names.toArray(new String[image_names.size()]);
					}
					}
				}
			}catch(Exception e){ }
						try {
							AddProduct ap = new AddProduct();
							ap.addProductImage(product_id, images);
							
							//req.setAttribute("image_names", image_names);
							req.setAttribute("product_id", product_id);
						} catch (SQLException e) {
						//	 TODO Auto-generated catch block
						e.printStackTrace();
						}
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
						
						finally {
							
							req.getRequestDispatcher("catalog_confirm.jsp").forward(req, resp);
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