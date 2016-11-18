<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Group6: CreateUser</title>
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-default" style="background-color:#5784cc">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/" style="color:white">Home</a></li>
					<li><a href="/user/userId" style="color:white">Create User</a></li>
					<li><a href="/user/getUserId" style="color:white">Get User</a></li>
					<li><a href="/phone" style="color:white">Create Phone</a></li>
					<li><a href="/phone/getPhoneId" style="color:white">Get Phone</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div>
		<div class="container col-sm-6" style="text-align:right">
			<form method="post" action="/user/userId">
				User Id: <input type="text" name="ID" readonly /><br/><br/>
				First Name: <input type="text" name="fname" pattern="{A-Za-z}{30}" required/><br/><br/>
				Last Name: <input type="text" name="lname" pattern="{A-Za-z}{30}" required/><br/><br/>
				Title/MI: <input type="text" name="title"  pattern="{A-Za-z}{4}" required/><br/><br/>
				<b>Address:</b><br/><br/>
				Street: <input type="text" name="street" required/><br/><br/>
				City: <input type="text" name="city"  pattern="{A-Za-z}{30}" required/><br/><br/>
				State: <input type="text" name="state" pattern="{A-Za-z}{15}" required/><br/><br/>
				Zip: <input type="number" name="zip" pattern="{10}" required/><br/><br/>
				<b>Phone Numbers Assigned:</b><br/><br/>
				Phone-1 : <input type="number" name="phoneno1" pattern="{10}"/><br/><br/>
				Description-1 : 
				<select name="desc1">
					<option value="Primary" selected>Primary</option>
					<option value="Home">Home</option>
					<option value="Office">Office</option>
				</select>
				<br/><br/>
				Phone-2 : <input type="number" name="phoneno2" pattern="{10}" /><br/><br/>
				Description-2 : 
				<select name="desc2">
					<option value="" selected></option>
					<option value="Primary">Primary</option>
					<option value="Home">Home</option>
					<option value="Office">Office</option>
				</select>
				<br/><br/>
				Phone-3 : <input type="number" name="phoneno3" pattern="{10}"/><br/><br/>
				Description-3 : 
				<select name="desc3">
					<option value="" selected></option>
					<option value="Primary">Primary</option>
					<option value="Home">Home</option>
					<option value="Office">Office</option>
				</select>
				<br/><br/>
				<input class="btn btn-primary" type="submit" value="Create" /><br/>
			</form>
		</div>
	</div>

	
</body>
