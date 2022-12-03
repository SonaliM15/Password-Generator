<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.User"%>

<%
String action = (String) request.getAttribute("action");
User session_user = (User) session.getAttribute("user");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Book Store</title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="font/bootstrap-icons.css">


</head>
<body id="login_page">



	<h1 class="d-flex justify-content-center mt-4 me-5 display-2">Online
		Book Store</h1>
	<div class="mt-5 me-5 d-flex justify-content-center">

		<form action="userurl?action=updatepass"
			class="rounded border border-warning p-5" method="post"
			id="changepassword">
			<div class="mb-3">
				<label for="userEmail" class="col-form-label-lg"><strong>User
						Name</strong></label> <br /> <input type="email" class="form-control-lg"
					id="userEmail" name="userEmail" placeholder="email@example.com"
					required="required" readonly="readonly" value="<%=session_user.getUserEmail() %>"/>

			</div>
			<div class="mb-3">
				<label for="userPassword" class="col-form-label-lg"><strong>Password</strong></label>
				<br /> <input type="password" class="form-control-lg"
					id="userPassword" name="userPassword" required="required">

			</div>

			<input class="btn btn-lg btn-success mt-3 me-5" type="submit"
				value="Change Password" />
		</form>
	</div>
</body>
</html>

