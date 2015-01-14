<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, goynaa.product.Product"%>    
<%
Product p = (Product)request.getAttribute("the_product");
if(p == null){
	out.println("p is null. That means it might be a direct product page pull up. So show the product details and");
}else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="productdetail">
<form action="" method="post">
 <table border="1">
 <tr>
     	<th>Product Property</th>
     	<th>Detail</th>
</tr>
 <tr>
		<td>Product ID</td>
		<td><input type="text" name="" value="${productid}"></input></td>
</tr>
	   <tr>
   	  		<td>Product Title</td>
    	 	<td>${product_title}</td>
    </tr>
    <tr>
   	  		<td>Product Description</td>
    	 	<td>${product_description}</td>
    </tr>
    <tr>
		     <td>Image</td>
      		 <td>
      		      <c:forEach items="${product_images}" var="image">
	     			<a href="<%=request.getContextPath()%>/product/image/${image}" target="_blank"><img src="file:///Users/rumana/Pictures/goynaa/images/product/${image}" height="50" width="50"></img></a>&nbsp&nbsp
         		  </c:forEach>
      		</td>                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    </tr>
     <tr>
     		<td>Color</td>
	      	<td> 
        		 <c:forEach items="${product_colors}" var="color">
	     			${color},
         		 </c:forEach>
         	</td>
    </tr>
</table>
<input type="submit">Update Product Detail</input>
</form>
</div>
</body>
</html>
<% } %>