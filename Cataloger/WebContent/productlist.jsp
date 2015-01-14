 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
product list
<div id="producttable">
<table border="0" cellpadding="10" cellspacing="10">
<tr><h4>Product List</h4></tr>
<tr>
<th>Product ID</th><!-- the image place holder -->
<th>Product Description</th><!-- the image place holder -->
<th>Product Page</th><!-- Brief Description/Title  Under Product Details-->
</tr>
<c:forEach items="${rows}" var="row">
<tr>
<td>${row.product_id}</td>
<td>${row.product_description}</td>
<td><a href="<%=request.getContextPath()%>/product?productid=${row.product_id}">Product Details</a></td>
</tr>
 </c:forEach>
</table>
</div>
</body>
</html>