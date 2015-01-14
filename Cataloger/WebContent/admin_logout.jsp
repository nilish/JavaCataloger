<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 

//session.setAttribute("cataloger_email", null);
//session.setAttribute("logged-in", null);
session.invalidate();
response.sendRedirect(request.getContextPath() + "/cataloger.jsp"); 

%>