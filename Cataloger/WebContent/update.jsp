<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/admin_dashboard.jsp">Go to Home - Cataloger Dashboard</a>

Find a Product
1.By Product Id
2.By Product Catagory
<form name="findProductForm" action="<%=request.getContextPath() %>/product" method="post">
Product Id<input type="text" name="productid"> <br>
<input type="hidden" name="page_id" value="update.jsp"/>
<button type="submit" name="submit" value="Find Product">Find the Product</button>
</form>
<% 

String s = (String)request.getAttribute("product_exist");
 if(s != null)
 {
	 %>
    <%=s %>
    product does not exist
    <%}%>

    
</body>
</html>