<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, goynaa.product.Product"%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Campaign Image Upload Form</title>
</head>
<body>
<h3>Campaign Image Upload form</h3>

<div class="instruction">
<fieldset class="instruction">
<ol>
<h4>Instruction</h4>
<li>Search the product</li>
<li>Check if existing campaign image already exist</li>
<li>If not, select the image to upload</li>
<li>If exist, if intent, update the image</li>
</ol>
</fieldset>
</div>
<% Product p = (Product)request.getAttribute("the_product");  
  if(p == null){
%>	  
	<div class="product_search_form">
		<fieldset>
		<h4>Which Product You Want to Upload Campaign Image?</h4> 
		<form name="" action="product" method="post"> 
		<input type="text" name="productid" value=""/>
		<input type="hidden" name="page_id" value="image_upload_campaign.jsp"/>
		<button type="submit" name="submit" value="product details">Find Product</button>
		</form>........
		</fieldset>
	</div> 
<% } else {%>
	
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
		     <td>Detail Images</td>
      		 <td>
      		      <c:forEach items="${product_images}" var="image">
	     			<a href="product/image/${image}" target="_blank"><img src="file:///Users/rumana/Pictures/goynaa/images/product/${image}" height="50" width="50"></img></a>&nbsp&nbsp
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
</div>

Upload the product campaign image
Product Id : ${productid}<br/>
<form method="post" action="campaignimageupload" enctype="multipart/form-data" name="image_upload_campaign">
Product Id : ${productid}<br/>
<input type="hidden" name="productid" value="${productid}" id="productid" /><br/>
Select the images <br/>
<input type="file" name="product_image" id="product_image"/><br/>
<button type="submit" name="upload">Upload</button>
</form>
<% } %>
</body>
</html>