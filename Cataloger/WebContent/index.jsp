<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Goynaa Cataloging</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <link href="http://www.goynaa.com/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/index.css" rel="stylesheet">
    <link href="sticky-footer-navbar.css" rel="stylesheet">
    <style>
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
            <a class="brand" href="#">GOYNAA Cataloging</a>
            <p>
             <button type="btn" class="navbar-form btn pull-right" onclick=location.href="cataloger.jsp">Login to Catalog</button>
             <!-- <button type="btn" class="navbar-form btn primary" onclick=location.href="signup.jsp">Sign Up for Goynaa Cataloging</button> -->
             </p>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
            </ul>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->
      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->
     <!-- Carousel <div id="myCarousel" class=" carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img height="50" src="http://www.goynaa.com/assets/img/blue_my.gif" alt="">
          <div class="container">
            <div class="carousel-caption">
              <!-- <h1>Example headline.</h1> -->
              <!-- <p class="lead">Chandelier Earring with white and maroon stones on antique victorian settings</p> -->
             <!--<button type="btn" class="btn primary" onclick=location.href="signup.jsp">Sign Up for Goynaa Cataloging</a>-->
            </div>
          </div>
        </div>
        </div>
    </div>
    <!-- /.carousel -->
    <!-- -->
    
    
    <!-- Wrap the rest of the page in another container to center all the content. -->
    <div class="container marketing">
    <h4>Products from Goynaa Catalog</h4>
    <img src="assets/img/girl_dress.JPG" width="100" height="200"/>
    <img src="assets/img/shoe.jpg" width="100" height="200"/>
    <img src="assets/img/jewelry.JPG" width="100" height="200"/>
    </div><!-- /.container -->
    <div id="footer">
      <div class="container">
      <ul class="navbar navbar-default">
         <a href="help/product.html">Products</a>&nbsp&nbsp&nbsp
         <a href="help/product.html">Pricing</a>&nbsp&nbsp&nbsp
         <a href="help/product.html">Policy</a>&nbsp&nbsp&nbsp
         <a href="help/contact.html">Contact</a><p class="text-muted credit">
      
      </ul>
      </div>
    </div>
     <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
   <script src=http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/js/bootstrap.min.js>></script>
    
     <script>
    $(function(){
        $('#myCarousel').carousel({
     	   interval: 2000;
            pause: hover;
        });
        
});
    </script>
  </body>
  <div id="footer">
	<footer>©2013 Goynaa.com<a href="<%=request.getContextPath()%>/privacy-policy">Privacy</a> and <a href="<%=request.getContextPath()%>/trademark-standards">Trademark Standards</a>
	</footer>
    </div>
</html>