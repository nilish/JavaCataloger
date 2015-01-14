package goynaa.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateProductServlet extends HttpServlet

{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//two option 
		//it is an individual update product request where search option need to be provided to pull the product details in editable 
		//form from database
	
		//second option is that the request already came in with a product id and using the product id the details of the product will be pulled from
		//the database
		
		String product_id = req.getParameter("productid");
		//String product_id = req.("product_id");
		if(product_id == null){
			System.out.println("give catalog user product search page for updating");
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		} else {
		   req.setAttribute("update_specific_product", true);
		   System.out.println("give specific product details with editable format");	
		   resp.sendRedirect("/Cataloger/product?productid="+product_id+"&update_specific_product="+true);
		   //req.getRequestDispatcher("/Cataloger/product?productid="+product_id).forward(req, resp);
		}
		}
		
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	
	
}
