<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Cataloger Account</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/CreateAccount" method="post">
Add New Cataloger User<br>
UserName : <input type="text" name="username" value=""/><br>
First Name: <input type="text" name="firstname" value=""/><br>
Last Name:<input type="text" name="lastname" value=""/><br>
Email:<input type="email" name="email" value=""/><br>
Password:<input type="password" name="password_main" value=""/><br>
Re-Type Password : <input type="password" name="password_retype" value=""/><br>
<button type="submit" value="submit" name="submit">Create User</button>
<button type="reset" value="reset" name="reset">Reset</button><br>
</form>
</body>
</html>