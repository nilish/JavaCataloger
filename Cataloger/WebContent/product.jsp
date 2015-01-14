 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, goynaa.product.Product"%>
  
    
<%
Product p = (Product)request.getAttribute("the_product");
if(p == null){
	out.println("p is null. That means it might be a direct product page pull up. So show the product details and");
}else {
%>
<!DOCTYPE html>
<html>
<head>
<title>${product_title}</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Goynaa">
</head>
<body>
 <div class="productdetail">
 <table border="1">
  	<tr>
     	<th>Product Property</th>
     	<th>Detail</th>
    </tr>
 <tr>
		<td>Product ID</td>
		<td>${productid}</td>
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
		     <td>Individual Images</td>
      		 <td>
      		      <c:forEach items="${product_images}" var="image">
	     			<a href="<%=request.getContextPath()%>/product/image/${image}" target="_blank"><img src="file:///Users/rumana/Pictures/goynaa/images/product/${image}" height="50" width="50"></img></a>&nbsp&nbsp
         		  </c:forEach>
      		</td>
    </tr>
       <tr>
		     <td>Campaign Image</td>
      		 <td>
	     		<a href="<%=request.getContextPath()%>/product/image/${campaign_image}" target="_blank"><img src="file:///Users/rumana/Pictures/goynaa/images/product/${campaign_image}" height="50" width="50"></img></a>&nbsp&nbsp
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
<p><a href="<%=request.getContextPath()%>/updateproduct?productid=${productid}">update the product details</a></p>
</div>
</body>
</html>
<% } %>