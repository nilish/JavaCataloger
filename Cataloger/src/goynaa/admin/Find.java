package goynaa.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Find extends HttpServlet{
	
	String result;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			
			{
		
		HttpSession session = req.getSession(true);
		//String username = req.getParameter("username");
		String username = "not good";
		int rows_num = 0;
		FindUser f = new FindUser();
		try {
			username = f.find_email("rumana024");
			//rows_num = f.num_rowws;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.setContentType("text/html");
	    PrintWriter pw = resp.getWriter();
	    pw.println("<html>");
	    pw.println("<head>");
	    pw.println("<title> Hello World </title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<h1> Hello, World!</h1>"+username);
	    pw.println("</body>");
	    pw.println("</html>");
	    pw.close();	
		
	
}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doGet(req, resp);
		
		
	}
	



}
