<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cataloger DashBoard - Add New Product</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="https://js.braintreegateway.com/v1/braintree.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
 <!-- Le styles -->
    <link href="http://www.goynaa.com/assets/css/bootstrap.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/index.css" rel="stylesheet">
    <link href="http://www.goynaa.com/assets/css/cataloger.css" rel="stylesheet">

<script>
function submissionCheck()
{
alert("Please fill up the  all required field" + document.forms["newProductForm"]["product_name"].value + "!")
}
</script>
</head>
<body>
	<!-- NAVBAR -->
<jsp:include page="cataloger_dashboard_top_navbar.jsp"></jsp:include>

<!--  <a href="<%= request.getContextPath()%>/admin_logout.jsp">Logout</a><br> -->
<!-- <p>These are dynamic content, displayed based on the login status , and only accessible by login, and stay during period admin is logged in</p> -->
<!--  <p>Logged In : <%= session.getAttribute("the_username") %></p> -->
<!--  <p>Session Id : <%= session.getId() %></p> -->
<!--  <% System.out.println("The Current Session ID is: " +session.getId()); %> -->

<form name="productCountForm" action="<%=request.getContextPath() %>/ProductCount" method="post">
<input type="hidden" name="page_id" value="add_product.jsp"/>
<button type="submit" name="submit" value="Number of Products">Find Current Number of Products</button>
</form>
Current Number of Products = 
<%= request.getParameter("product_count") %>
<form name="newProductForm" action="<%=request.getContextPath() %>/AddProduct" method="post" onsubmit="submissionCheck()">
<h3>Add New Product</h3>
<h2>Fill the Information About the Product</h2>
Product Title    :    <input type="text" name="product_title"><br>
Product Description    :    <input type="text" name="product_description"><br>
<h2>Product Color</h2>
<h5>(select all colors that apply)</h5>
<table border="1">
<tr>
	<th>Color Image</th>
	<th>Color Name</th>
	<th>Color Image</th>
	<th>Color Name</th>
</tr>
<tr>
    <td><img src="images/color_bright_red.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="red">Bright Red</td>
    <td><img src="images/color_maroon.gif" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="maroon">Maroon</td>
</tr>
<tr>    
     <td><img src="images/color_bright_green.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="green">Bright Green</td>
      <td><img src="images/color_forest_green.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="green">Forest Green</td>
</tr>   
<tr>
    <td><img src="images/color_olive_green.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="green">Olive Green</td>
    <td><img src="images/color_white.gif" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="white">White</td>
</tr>    
<tr>
    <td><img src="images/color_turquoise_blue.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="blue">Turquoise Blue</td>
    <td><img src="images/color_sky_blue.png" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="blue">Sky Blue</td>
</tr>    
<tr>
    <td><img src="images/color_royal_pink.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="pink">Royal Pink</td>
    <td><img src="images/color_royal_blue.gif" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="blue">Royal Blue</td>
</tr>    
<tr>
    <td><img src="images/color_purple.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="purple">Purple</td>
    <td><img src="images/color_orange.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="orange">Orange</td>
</tr>    
<tr>
    <td><img src="images/color_light_pink.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="pink">Light Pink</td>
     <td><img src="images/color_emerald_green.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="green">Emerald Green</td>
</tr>    
<tr>
    <td><img src="images/color_brick_red.gif" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="red">Brick Red</td>
    <td><img src="images/color_black.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="black">Black</td>
</tr>    
<tr>
    <td><img src="images/color_violet.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="violet">Violet</td>
    <td><img src="images/color_purple.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="purple">Purple</td>
</tr>
<tr>
    <td><img src="images/color_copper.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="copper">Copper</td>
    <td><img src="images/color_brown.gif" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="brown">Brown</td>
</tr>
<tr>
    <td><img src="images/color_bronze.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="bronze">Bronze</td>
    <td><img src="images/color_silver.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="silver">Silver</td>
</tr>
<tr>
    <td><img src="images/color_golden.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="golden">Golden</td>
    <td><img src="images/color_beige.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="beige">Beige</td>
</tr>
<tr>
    <td><img src="images/color_yellow.jpg" width="30" height="30"></td>
    <td><input type="checkbox" name="product_color" value="yellow">Yellow</td>

</tr>
</table>
<p>
<h2>Product Crafting Base Material</h2>
<p>(If any, select all that applies)</p>
<p>
<input type="checkbox" name="base_material" value="none">None<br>
<input type="checkbox" name="base_material" value="18k_gold">18K Gold<br>
<input type="checkbox" name="base_material" value="14k_gold">14K Gold<br>
<input type="checkbox" name="base_material" value="10k_gold">10K Gold<br>
<input type="checkbox" name="base_material" value="gold_plated_silver">Gold Plated Silver<br>
<input type="checkbox" name="base_material" value="gold_plated_copper">Gold Plated Copper<br>
<input type="checkbox" name="base_material" value="gold_plated_bronze">Gold Plated Bronze<br>
<input type="checkbox" name="base_material" value="gold_plated">Gold Plated<br>
<input type="checkbox" name="base_material" value="silver_999">Silver(99.9%)<br>
<input type="checkbox" name="base_material" value="sterling_silver_925">Sterling Silver(92.5%)<br>
<input type="checkbox" name="base_material" value="silver_plated_copper">Silver Plated Copper<br>
<input type="checkbox" name="base_material" value="silver_plated">Silver Plated<br>
<input type="checkbox" name="base_material" value="bronze">Bronze<br>
<input type="checkbox" name="base_material" value="alloy">Alloy<br>
<input type="checkbox" name="base_material" value="fabric">Fabric<br>
<input type="checkbox" name="base_material" value="jute">Jute<br>
<input type="checkbox" name="base_material" value="clay">Clay<br>
<input type="checkbox" name="base_material" value="wood">Wood<br>
<input type="checkbox" name="base_material" value="bead">Bead<br>
<input type="checkbox" name="base_material" value="peral">Peral<br>
<input type="checkbox" name="base_material" value="leather">Leather<br>
<input type="checkbox" name="base_material" value="feather">Feather<br>
</p>

<p>
<h2>Stone and Material Used</h2>
<p>(If any, select all that applies)</p>
<p>
<input type="checkbox" name="stone" value="none">None<br>
<input type="checkbox" name="stone" value="ruby">Ruby<br>
<input type="checkbox" name="stone" value="emerald">Emerald<br>
<input type="checkbox" name="stone" value="peridot">Peridot<br>
<input type="checkbox" name="stone" value="blue_sapphire">Blue Sapphire<br>
<input type="checkbox" name="stone" value="tundra_sapphire">Tundra Sapphire<br>
<input type="checkbox" name="stone" value="coral">Coral<br>
<input type="checkbox" name="stone" value="blue_tanzanite">Blue Tanzanite<br>
<input type="checkbox" name="stone" value="pink_tanzanite">Pink Tanzanite<br>
<input type="checkbox" name="stone" value="silver_plated_copper">Silver Plated Copper<br>
<input type="checkbox" name="stone" value="silver_plated_">Silver Plated Bronze<br>
<input type="checkbox" name="stone" value="alloy">Alloy<br>
<input type="checkbox" name="stone" value="fabric">Fabric<br>
<input type="checkbox" name="stone" value="jute">Jute<br>
<input type="checkbox" name="stone" value="clay">Clay<br>
<input type="checkbox" name="stone" value="wood">Wood<br>
<input type="checkbox" name="stone" value="bead">Bead<br>
<input type="checkbox" name="stone" value="leather">Leather<br>
<input type="checkbox" name="stone" value="feather">Feather<br>
</p>
<p>
<h2>Product Weight</h2>
Weight(in gram)<input type="text" name="product_weight" value=""/>grams
</p>
<p>
<h2>Product Length</h2>
Length (in centimeter): <input type="text" name="product_length" value=""/>centimeters
</p>
<h2>Product Width</h2>
Width (in centimeter): <input type="text" name="product_width" value=""/>centimeters
</p>
<p>
<h2>Product Shape</h2>(Select All that applies)
<p>
<input type="checkbox" name="stone" value="none">None<br>
<input type="checkbox" name="shape" value="round">Round<br>
<input type="checkbox" name="shape" value="rectangle">Rectangle<br>
<input type="checkbox" name="shape" value="straight_line">Straight Line<br>
<input type="checkbox" name="shape" value="square">Square<br>
<input type="checkbox" name="shape" value="oval">Oval<br>
<input type="checkbox" name="shape" value="triangle">Triangle<br>
<input type="checkbox" name="shape" value="multishape">Multishape<br>
<input type="checkbox" name="shape" value="circle">Circle<br>
<input type="checkbox" name="shape" value="leaf">Leaf<br>
<input type="checkbox" name="shape" value="cone">Cone<br>
<input type="checkbox" name="shape" value="curve_line">Curve Line<br>
<input type="checkbox" name="shape" value="animal">Animal<br>
<input type="checkbox" name="shape" value="insect">Insect<br>
<input type="checkbox" name="shape" value="flower">Flower<br>
<input type="checkbox" name="shape" value="things">Things<br>
<input type="checkbox" name="shape" value="layers">Layers<br>
<input type="checkbox" name="shape" value="drop">Drop<br>
</p>
<p>
<h2>Product Placement</h2>
<h5>(For set, select individual item option (ex: earring and necklace) and also the set option)</h5>
<input type="checkbox" name="placement" value="none">None<br>
<input type="checkbox" name="placement" value="set"/>Set<br>
<input type="checkbox" name="placement" value="necklace"/>Necklace<br>
<input type="checkbox" name="placement" value="pendant"/>Pendant<br>
<input type="checkbox" name="placement" value="bangle"/>Bangle<br>
<input type="checkbox" name="placement" value="bracelet"/>Bracelet<br>
<input type="checkbox" name="placement" value="earring"/>Earring<br>
<input type="checkbox" name="placement" value="ankel"/>Ankel<br>
<input type="checkbox" name="placement" value="hair"/>Hair Pin<br>
<input type="checkbox" name="placement" value="tiara"/>Tiara<br>
<input type="checkbox" name="placement" value="belt"/>Belt<br>
<input type="checkbox" name="placement" value="ring"/>Ring<br>
<input type="checkbox" name="placement" value="brooch"/>Brooch<br>
</p>
<p>
<h2>Product Type</h2>
<input type="checkbox" name="type" value="none">None<br>
<input type="checkbox" name="type" value="jewelry"/>Jewelry<br>
<input type="checkbox" name="type" value="clothing"/>Clothing<br>
<input type="checkbox" name="type" value="Shoe"/>Shoe<br>
</p>
<p>
<h2>Product Style</h2>
<input type="checkbox" name="style" value="none">None<br>
<input type="checkbox" name="style" value="tribal">Tribal<br>
<input type="checkbox" name="style" value="victorian">Victorian<br>
<input type="checkbox" name="style" value="modern">Modern<br>
<input type="checkbox" name="style" value="contemporary">Contemporary<br>
<input type="checkbox" name="style" value="indian">Indian<br>
<input type="checkbox" name="style" value="indian">Pakistani<br>
<input type="checkbox" name="style" value="persian">Persian<br>
<input type="checkbox" name="style" value="chinese">Chinese<br>
<input type="checkbox" name="style" value="tibet">Tibet<br>
<input type="checkbox" name="style" value="Egyptian">Egyptian<br>
<input type="checkbox" name="style" value="greek">Greek<br>
<input type="checkbox" name="style" value="native_indian">Native Indian<br>
<input type="checkbox" name="style" value="byzentine">Byzentine<br>
<input type="checkbox" name="style" value="jamdani">Jamdani<br>
<input type="checkbox" name="style" value="nizam">Nizam<br>
<input type="checkbox" name="style" value="coin">Coin<br>
</p>
<p>
<h2>Product Size</h2>
<h5>(Select all that applies, set product earring might be small and necklace is large)</h5>
<input type="checkbox" name="size" value="none">None<br>
<input type="checkbox" name="size" value="small">small<br>
<input type="checkbox" name="size" value="small-medium">Small To Medium<br>
<input type="checkbox" name="size" value="medium">Medium<br>
<input type="checkbox" name="size" value="medium-large">Medium to Large<br>
<input type="checkbox" name="size" value="large">Large<br>
<input type="checkbox" name="size" value="extra-large">Extra Large<br>
</p>
<input type="reset" name="reset" value="Reset">
<input type="submit" name="submit" value="Add to Catalog">
</form>
</body>
</html>