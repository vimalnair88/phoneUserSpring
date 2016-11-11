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
    
    <title>Group2: GetPhone</title>
    
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
		    background-color: #4CAF50;
		    color: white;
		}
	</style>
</head>
<body>

	<div class="row" role="navigation">
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
	
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="container col-sm-6" style="text-align:center">
			<form method="post" action="${phone.getPhone_id()}">
				Phone ID: <input type="number" name="id" value="${phone.getPhone_id()}" readonly/><br/><br/>
				Phone Number: <input type="text" name="phone" value="${phone.getPhoneNumber()}"/><br/><br/>
				Description: <input type="text" name="desc" value="${phone.getDesc()}" /><br/><br/>
				<b>Address:</b><br/><br/>
				Street: <input type="text" name="street" value="${address.getStreet()}"/><br/><br/>
				City: <input type="text" name="city" value="${address.getCity()}"/><br/><br/>
				State: <input type="text" name="state" value="${address.getState()}"/><br/><br/>
				Zip: <input type="text" name="zip" value="${address.getZip()}"/><br/><br/>
				<input class="btn btn-primary" type="submit" value="Update" /> <br/><br/>
			</form>
			<form method="post" action="/phone/delete/${phone.getPhone_id()}">
				<input class="btn btn-primary" type="submit" value="Delete"/><br/>
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<b>Assigned Users to this Phone:</b><br/><br/>
			<table>
			  <tr>
			  	<th>User ID</th>
			    <th>First Name</th>
			    <th>Last Name</th>
			    <th>Operation</th>
			  </tr>
			  <c:forEach items="${user}" var="usr">
			  <form method="post" action="/phone/deleteUser/${phone.getPhone_id()}/${usr.getId()}">
				  <tr>
				    <td>${usr.getId()}</td>
				    <td>${usr.getFirstname()}</td>
				    <td>${usr.getLastname()}</td>
				    <td> <input type="submit" value="Remove" /></td>
				  </tr>
			  </form>
			  </c:forEach> 
			</table>
			<br/>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<br/>
			<b>Unassigned Users to this Phone:</b><br/><br/>
			<table>
			  <tr>
			  	<th>User ID</th>
			    <th>First Name</th>
			    <th>Last Name</th>
			    <th>Operation</th>
			  </tr>
			<c:forEach items="${NotAssigned}" var="usr">
			<form method="post" action="/phone/addUser/${phone.getPhone_id()}/${usr.getId()}">
			  <tr>
			    <td>${usr.getId()}</td>
			    <td>${usr.getFirstname()}</td>
			    <td>${usr.getLastname()}</td>
			    <td> <button>Add</button></td>
			  </tr>
			 </form> 
			</c:forEach>
  			</table>
  		</div>	
		<div class="col-sm-2"></div>
	</div>	
</body>
