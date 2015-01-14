<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
if(session.getAttribute("cataloger_email") == null ||session.getAttribute("logged-in") == null ||session.getMaxInactiveInterval()== 20000){	
	response.sendRedirect(request.getContextPath() + "/cataloger.jsp"); 
}
//String user_email = (String)session.getAttribute("cataloger_email");
%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goynaa Cataloging Signup</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
 <!-- Le styles -->
    <link href="http://www.goynaa.com/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/index.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/cataloger.css" rel="stylesheet">
    <style>
    #logodiv
{
    margin: 20px auto 0;
    height:29px;
    width: 602px;
}
    #signin
{
  	margin: 20px auto 0;
  	width: 500px;
	border:solid 1px;
	padding-right: 20px;
	padding-left: 20px;
	padding-bottom: 20px;
	padding-top: 20px;
	background-color:white;  
}  
    #form_validation_message
{
    margin: 20px auto 0;
    width: 400px;
	border:solid 1px red;
	padding-right: 20px;
	padding-left: 20px;
	padding-bottom: 20px;
	padding-top: 20px;
	background-color:white; 
	visibility:hidden;
} 
    #server_authnetication_message
{
    margin: 20px auto 0;
    width: 400px;
	border:solid 1px white;
	padding-right: 20px;
	padding-left: 20px;
	padding-bottom: 20px;
	padding-top: 20px;
	background-color:white; 
}  
	#footer
{
 	margin: 20px auto 0;
    width: 500px;
	padding-right: 20px;
	padding-left: 20px;
	padding-bottom: 20px;
	padding-top: 20px;
	background-color:white;  
}
    </style>  
</head>
<body>
	<!-- NAVBAR -->
<jsp:include page="cataloger_dashboard_top_navbar.jsp"></jsp:include>

<div class="container">
<h3>Administrator DashBoard</h3>
<!-- <p>These are dynamic content, displayed based on the login status,and only accessible by login, and stay during period admin is logged in</p> -->
<!--  <p>Session Id : <%= session.getId() %></p> -->
<!-- <% System.out.println("The Current Session ID is: " +session.getId()); %> -->
<h4>Cataloging Tasks - what would you like to do?</h4><br>
<a href="<%=request.getContextPath()%>/add_product.jsp">Add New Product</a><br>
<a href="<%=request.getContextPath()%>/delete">Delete</a><br>
<a href="<%=request.getContextPath()%>/updateproduct">Update Product</a><br>
<a href="<%=request.getContextPath()%>/productlist">View Product List</a><br>
<br>
<h4>Inventory Tasks</h4>
<a href="<%=request.getContextPath()%>/findInventoryItem">Find Inventory Item</a><br>
<a href="<%=request.getContextPath()%>/createInventory">Create New Inventory</a><br>
<a href="<%=request.getContextPath()%>/updateInventory">Update Inventory</a><br> 
</div>
</body>
<div id="footer">
	<footer>©2013 Goynaa.com<a href="<%=request.getContextPath()%>/privacy-policy">Privacy</a> and <a href="<%=request.getContextPath()%>/trademark-standards">Trademark Standards</a><br/>
	<p><%= new java.util.Date() %></p>
	</footer>
    </div>
</html>