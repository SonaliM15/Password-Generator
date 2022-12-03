<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pojo.User"%>

<%User session_user = (User) session.getAttribute("user"); %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="font/bootstrap-icons.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">Book Store</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="bookurl?action=list">Book List</a></li>
					<li class="nav-item"><a class="nav-link" href="userurl?action=list">User List</a></li>
					<li class="nav-item"><a class="nav-link" href="bookurl?action=add">Add book</a></li>
					<li class="nav-item"><a class="nav-link" href="userurl?action=add">Add user</a></li>
					<li class="nav-item"><a class="nav-link" href="aboutus.jsp" >About Us</a>
					</li>
				</ul>
			</div>
			<div class ="float-end">
				<p>
					Welcome <strong><%=session_user.getFirstName()%>  </strong>
					<a href="userurl?action=logout" class="btn btn-outline-secondary me-2"
					onclick="return confirm('Are you sure you want to logout?')">Logout</a>
				</p>
			
			</div>
		</div>
	</nav>