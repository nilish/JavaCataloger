package goynaa.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductCount
 */
@WebServlet("/ProductCount")
public class ProductCountServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String page_id = request.getParameter("page_id");
		response.setContentType("text/html");
        ProductCountPOJO product_count = new ProductCountPOJO();
        int result = 0;
        String error;
		try {
			result = product_count.countProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error = e.getMessage();
			response.sendRedirect(request.getContextPath() + "/error.jsp?error="+error);
		}
        request.setAttribute("product_count", result);
      //  request.getRequestDispatcher("add_product.jsp").forward(request, response); 
       
        if(page_id.equals("add_product.jsp")){
        	System.out.println("redirecting to add_product.jsp with the product count");
       response.sendRedirect(request.getContextPath() + "/add_product.jsp?product_count="+result);
        }
        
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}