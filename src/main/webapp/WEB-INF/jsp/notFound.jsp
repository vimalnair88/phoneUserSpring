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
    
    <title>Group2: NotFound</title>
    
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<div role="navigation">
		<div class="navbar navbar-default" style="background-color:#42f48f">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/" style="color:black">Home</a></li>
					<li><a href="/user/userId" style="color:black">Create User</a></li>
					<li><a href="/user/getUserId" style="color:black">Get User</a></li>
					<li><a href="/phone" style="color:black">Create Phone</a></li>
					<li><a href="/phone/getPhoneId" style="color:black">Get Phone</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container" id="homeDiv">
		<div class="jumbotron text-center">
			<h2><b>${code} </b><br/> ${error}</h2>
			
		</div>
	</div>
	
</body>
