
<!DOCTYPE html>
<html>
	<head>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goynaa Cataloging Signin</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
 <!-- Le styles -->
    <link href="http://www.goynaa.com/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/index.css" rel="stylesheet">
    <link href="sticky-footer-navbar.css" rel="stylesheet">
    <style>
    #logodiv
{
    margin: 20px auto 0;.
    height:29px;
    width: 602px;
}
    #login
{
  	margin: 20px auto 0;
  	width: 500px;
	border:solid 1px grey;
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
	background-color:yellow; 
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
	<div>
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">
        <div class="navbar navbar-inverse">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <a class="brand" href="index.jsp?ref=logo_clicked">Goynaa Cataloging</a>
           <button type="btn" class="navbar-form btn pull-right" onclick=location.href="signup.jsp">Not Register? SignUp Now</button>
            <!-- <button type="btn" class="navbar-form btn pull-right" onclick=location.href="signin.jsp">Sign and Shop</button> -->
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->
    <div id="login">
		<form action="AdminLogin" method="post">
			<h4>Log into Goynaa Cataloging</h4>
			<label>E-Mail</label>
			<input type="email" class="span3" name="email" placeholder="Type email here...">
			<label>Password</label>
			<input type="password" class="span3" name="password" placeholder="Type password here..."><br/>
			<button type="submit" class="btn btn-info">Submit</button>
			<button type="reset" class="btn">Clear</button>	
		</form>
		Signin Help<br/>
<a href="passwordrecovery.jsp">I forgot my password</a><br/>
<!--  <a href="updateemail.jsp">I need to change my email</a><br/> -->
		</div>
	</body>
	<div id="footer">
	<footer>�2013 Goynaa.com<a href="<%=request.getContextPath()%>/privacy-policy">Privacy</a> and <a href="<%=request.getContextPath()%>/trademark-standards">Trademark Standards</a>
	</footer>
    </div>
</html>