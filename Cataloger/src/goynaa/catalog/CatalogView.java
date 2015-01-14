package goynaa.catalog;


import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CatalogView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		String choice_name = null;
		String choice = null;
		if(req.getParameterNames().nextElement() != null)
		{
		    choice = req.getParameterNames().nextElement();
	    //println the value into the console
		System.out.println(choice);
		req.getSession().setAttribute("choice", choice);
	    if(choice.equals("color")){
	       choice_name = req.getParameter("color");
	       System.out.println(choice_name);	       
	    }
	    if(choice.equals("material")){
	    	choice_name = req.getParameter("material");
		       System.out.println(choice_name);
	    }
	    
	    
	    if(choice.equals("design")){
	    	choice_name = req.getParameter("design");
		       System.out.println(choice_name);
	    }
	    
	    
	    req.getSession().setAttribute("choice_name", choice_name);
	    
	    }
		try{
		PullCatalog view = new PullCatalog();
		List<Row> rows = view.viewCatalog(choice, choice_name);
		req.setAttribute("rows", rows);
		}catch(Exception e){
			req.setAttribute("error", "Retrieving rows failed.");
			e.printStackTrace();
		}
		
		finally{
			req.getRequestDispatcher("catalog.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}