<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import = "bootsample.model.Phone" %>
<%@ page import = "org.springframework.ui.ModelMap"%>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Group6: GetUser</title>
    
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
	<style>
		table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		th, td {
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even){background-color: #f2f2f2}
		
		th {
		    background-color: #5784cc;
		    color: white;
		}
	</style>
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
		<div class="container col-sm-6" style="text-align:left">
			<form method="post" action="${user.getId()}">
				<b>User Details</b><br/>
				User Id: <input type="text" name="userId" value="${user.getId()}" readonly /><br/><br/>
				First Name: <input type="text" name="firstName" value="${user.getFirstname()}"/><br/><br/>
				Last Name: <input type="text" name="lastName" value="${user.getLastname()}"/><br/><br/>
				Title/MI: <input type="text" name="title" value="${user.getTitle()}"/><br/><br/>
				<b>Address:</b><br/><br/>
				Street: <input type="text" name="street" value="${user.getAddress().getStreet()}"/><br/><br/>
				City: <input type="text" name="city" value="${user.getAddress().getCity()}"/><br/><br/>
				State: <input type="text" name="state" value="${user.getAddress().getState()}"/><br/><br/>
				Zip: <input type="text" name="zip" value="${user.getAddress().getZip()}"/><br/><br/>
				<input class="btn btn-primary" type="submit" value="Update"/><br/><br/>
			</form>
			<form method="post" action="/user/delete/${user.getId()}">
				<input class="btn btn-primary" type="submit" value="Delete"/><br/><br/>
			</form>
			<b>Phone Numbers Assigned:</b><br/><br/>
			<table>
					<tr>
						<th>Phone Number</th>
						<th>Description</th>
					</tr>
					<c:forEach items="${phones}" var="phone">
					<tr>
						<td>${phone.getPhoneNumber()}</td>
						<td>${phone.getDesc()}</td>
					</tr>
					</c:forEach>
				</table>
		</div>
	</div>
	
</body>
