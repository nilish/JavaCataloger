<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="goynaa.admin.GetTableList, java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){ 
        	$("p").click(function(){
                 //var database_table = 'all';
                 $.post("http://localhost:8080/Cataloger/dbquery",
                		 {database_table:"all"},
                		 function(data, status) {alert("\nStatus: " + status);}
                		 //{$("#database_table").html(data);
                    );
            });
        });
       
    </script>
    
    
    
    
</head>
<body>
Select table to insert Data
   
   <%
   GetTableList gtl = new GetTableList();
   List<String> tables = gtl.getTableList();
   
   %>
   <select name="database_table" id="database_table">
   <option value=>-Select a Table-</option>
    <c:forEach items="${tables}">
        <option value="${table.value}">${table.value}</option>
    </c:forEach>
    </select>


</body>
</html>