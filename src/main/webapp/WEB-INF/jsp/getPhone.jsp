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
    
    <title>Group 2: User</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
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
					<li><a href="/user" style="color:black">Create User</a></li>
					<li><a href="/user/getUserId" style="color:black">Get User</a></li>
					<li><a href="phone" style="color:black">Create Phone</a></li>
					<li><a href="phone/getPhoneId" style="color:black">Get Phone</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div>
		<div class="col-sm-3"></div>
		<div class="container col-sm-6" style="text-align:center">
			<form method="post" action="/phone/phoneId">
				Phone Number: <input type="text" name="phone" /><br/><br/>
				Description: <input type="text" name="desc" /><br/><br/>
				<b>Address:</b><br/><br/>
				Street: <input type="text" name="street" /><br/><br/>
				City: <input type="text" name="city" /><br/><br/>
				State: <input type="text" name="state"/><br/><br/>
				Zip: <input type="text" name="zip" /><br/><br/>
				<b>Assign User:</b><br/><br/>
				First Name: <input type="text" name="firstName"/><br/><br/>
				Last Name: <input type="text" name="lastName"/><br/><br/>
				User Id: <input type="number" name="userId" required/><br/><br/>
				<input type="submit" value="Create" />
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
	
</body>
