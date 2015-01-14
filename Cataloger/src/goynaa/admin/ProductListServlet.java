package goynaa.admin;

import goynaa.catalog.PullCatalog;
import goynaa.catalog.Row;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductListServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		try{
			PullCatalog view = new PullCatalog();
			List<Row> rows = view.viewProductList();
			req.setAttribute("rows", rows);
			}catch(Exception e){
				req.setAttribute("error", "Retrieving rows failed.");
				e.printStackTrace();
			}
			
			finally{
				req.getRequestDispatcher("productlist.jsp").forward(req, resp);
			}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	

}
