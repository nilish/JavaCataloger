<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>Upload Product Images</title></head>
<body>
<form method="post" action="ImageUpload" enctype="multipart/form-data" name="image_upload">
Upload Product Image
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