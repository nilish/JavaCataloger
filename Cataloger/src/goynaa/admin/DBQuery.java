package goynaa.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBQuery extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query = req.getParameter("database_table");
		//System.out.println("query what? "+query);
		if(query == "all"){
			System.out.println("show all tables");
	
				resp.setContentType("text/html");
		        GetTableList table_list = new GetTableList();
		        List<String> result = null;
		        String error;
				try {
					result = table_list.getTableList();
					req.setAttribute("result", result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					error = e.getMessage();
					resp.sendRedirect(req.getContextPath() + "/error.jsp?error="+error);
				}
				
		}		
				req.getRequestDispatcher("new_list_data.jsp").forward(req, resp);
		
			
		}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	

}
