<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- NAVBAR -->
	<div>
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">
        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
               <p class="brand">Goynaa Cataloging </p>
            <!-- <button type="btn" class="navbar-form btn pull-right" onclick=location.href="">Already Registered? Login</button> -->
          
            <button type="btn" class="navbar-form btn pull-right" onclick=location.href="admin_logout.jsp">Logout</button><br/>
            Logged in: <%= session.getAttribute("cataloger_email") %>
            Time : <p><%= session.getAttribute("login_time")%></p>
            <!--  <p><a class="pull-right" href="<%= request.getContextPath()%>/admin_logout.jsp">Logout</a></p> -->
            <div class="nav-collapse collapse">
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->
</body>
</html>