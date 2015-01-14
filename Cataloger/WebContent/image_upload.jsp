<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%

if(session.getAttribute("the_username") == null || session.getMaxInactiveInterval() == 1000){
	
	response.sendRedirect(request.getContextPath() + "/cataloger.jsp"); 
}
  
%>  
<!DOCTYPE html>
<html>
<head><title>Upload Product Images</title></head>
<body>
<form method="post" action="ImageUpload" enctype="multipart/form-data" name="image_upload">
<%if(request.getParameter("product_id") == null) { //ask which product id these images are for %>
Upload Product Images for Product Id :<input type="text" name="product_id" value=""/><br/>
<%} else {%>
Product Id is :<%=request.getParameter("product_id")%>
<input type="hidden" name="product_id" value="<%=request.getParameter("product_id")%>"/><br/>
<% } %>
<br/>
Select the images, depending on how many image available :<br/>
<input type="file" name="product_image" /><br/>
<input type="file" name="product_image" /><br/>
<input type="file" name="product_image" /><br/>
<input type="file" name="product_image" /><br/>
<button type="submit" name="upload">Upload</button>
</form>
</body>
</html>