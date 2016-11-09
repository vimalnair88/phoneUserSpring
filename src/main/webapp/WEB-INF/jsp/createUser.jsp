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
    
    <title>Group 2: CreateUser</title>
    
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
		<div class="navbar navbar-default" style="background-color:#42f48f">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/" style="color:black">Home</a></li>
					<li><a href="/user/userId" style="color:black">Create User</a></li>
					<li><a href="/user/userId" style="color:black">Get User</a></li>
					<li><a href="/user/getUserId" style="color:black">Update User</a></li>
					<li><a href="/user/getUserId" style="color:black">Delete User</a></li>
					<li><a href="phone" style="color:black">Create Phone</a></li>
					<li><a href="phone/getPhoneId" style="color:black">Get Phone</a></li>
					<li><a href="phone/getPhoneId" style="color:black">Update Phone</a></li>
					<li><a href="phone/getPhoneId" style="color:black">Delete Phone</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div>
		<div class="col-sm-3"></div>
		<div class="container col-sm-6" style="text-align:center">
			<form method="post" action="/user/userId">
				First Name: <input type="text" name="fname" /><br/><br/>
				Last Name: <input type="text" name="lname" /><br/><br/>
				Title/MI: <input type="text" name="title" /><br/><br/>
				<b>Address:</b><br/><br/>
				Street: <input type="text" name="street" /><br/><br/>
				City: <input type="text" name="city" /><br/><br/>
				State: <input type="text" name="state"/><br/><br/>
				Zip: <input type="text" name="zip" /><br/><br/>
				<b>Phone Numbers Assigned:</b><br/><br/>
				Phone-1 : <input type="text" name="phoneno1" /><br/><br/>
				Description-1 : <input type="text" name="desc1" /><br/><br/>
				Phone-2 : <input type="text" name="phoneno2" /><br/><br/>
				Description-2 : <input type="text" name="desc2" /><br/><br/>
				Phone-3 : <input type="text" name="phoneno3" /><br/><br/>
				Description-3 : <input type="text" name="desc3" /><br/><br/>
				<input type="submit" value="Create" />
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>

	
</body>
