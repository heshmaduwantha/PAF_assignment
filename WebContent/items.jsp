<%@ page import="model.Item" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="Components/jquery-3.6.0.js"></script>
<script src="Components/items.js"></script>
</head>
<body> 
<div class="container"><div class="row"><div class="col-6"> 
<h1>User Management </h1>
<form id="formItem" name="formItem">
 User Name: 
 <input id="userName" name="userName" type="text" 
 class="form-control form-control-sm">
 <br>User NIC: 
 <input id="userNIC" name="userNIC" type="text" 
 class="form-control form-control-sm">
 <br> Contact Number: 
 <input id="contactNumber" name="contactNumber" type="text" 
 class="form-control form-control-sm">
 <br> User Type: 
 <input id="userType" name="userType" type="text" 
 class="form-control form-control-sm">
 <br>
 
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
       Item itemObj = new Item(); 
	 out.print(itemObj.readUsers()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>
