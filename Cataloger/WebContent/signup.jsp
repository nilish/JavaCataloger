<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goynaa Cataloging Signup</title>
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
    margin: 20px auto 0;
    height:29px;
    width: 602px;
}
    #signin
{
  	margin: 20px auto 0;
  	width: 500px;
	border:solid 1px;
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
	background-color:white; 
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
            <a class="brand" href="index.jsp?ref=logo_clicked">Goynaa Cataloging </a>
            <button type="btn" class="navbar-form btn pull-right" onclick=location.href="cataloger.jsp">Already Registered? Login</button>
            <div class="nav-collapse collapse">
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->
<div id="form_validation_message">
<p id="validation_error"/>
</div>
<div id="server_authnetication_message">
<c:out value="${error_message}" />
</div>
<div id="signin">
<h4>New Catalog Sign Up</h4>
<form name="signin_form" action="signup" method="post" onsubmit="return validateForm();">
<label>What is your email address?</label>
<label><input type="email" class="span3" name="new_email" placeholder="Type email here..."></label>
<label>Choose a password</label>
<input type="password" class="span3" name="new_password" id="password" placeholder="Type password here..."><br/>
	<button type="submit" class="btn btn-info">Sign Up</button>
	<button type="reset" class="btn">Reset</button>
	</form>
</div>
<div id="footer">
<a href="/help/customer/condition_of_use.html">Conditions of Use</a>&nbsp&nbsp<a href="/help/customer/privacy_policy_notice.html">Privacy Notice</a>© 2013, Goynaa.com.
</div>
<script>
function validateForm()
	{
		var email_value=document.forms["signin_form"]["new_email"].value;
		var atpos=email_value.indexOf("@");
		var dotpos=email_value.lastIndexOf(".");
		var password_value = document.forms["signin_form"]["new_password"].value;
		
		//if(document.getElementById("newuser").checked){
		  //   user_type = document.getElementById("newuser").value;
		//}
		
		//if(document.getElementById("registereduser").checked){
		  //   user_type = document.getElementById("registereduser").value;
		//}
		
		//document.write(user_type);
    
		if(atpos<1 || dotpos<atpos+2 || dotpos+2>=email_value.length || email_value.length < 1)    
	{
   		document.getElementById("form_validation_message").style.visibility ="visible";
   		document.getElementById("validation_error").innerHTML ="There is an error occured.";
  		document.getElementById("form_validation_message").innerHTML ="<img src='assets/img/red_error.jpg' height='30' width='30'/>An error has occured.<br/>The email field is empty or the invalid email format";
  		//email_value="";
  		return false;. 
  	} 
	if((password_value.length < 1) & (email_value.length > 1))
  	{	
		document.getElementById("form_validation_message").style.visibility ="visible";
  		document.getElementById("form_validation_message").innerHTML ="<img src='assets/img/red_error.jpg' height='30' width='30'/>An error has occured.<br/>The password field is empty.";
  		//email_value=null;
  		return false;	
};
	};
</script>		
</body>
</html>