<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

		<form action="userurl?action=login"
			class="rounded border border-warning p-5" method="post"
			id="login_form">
			<div class="mb-3">
				<label for="userEmail" class="col-form-label-lg"><strong>User
						Name</strong></label> <br /> <input type="email" class="form-control-lg"
					id="userEmail" name="userEmail" placeholder="email@example.com"
					required="required">

			</div>
			<div class="mb-3">
				<label for="userPassword" class="col-form-label-lg"><strong>Password</strong></label>
				<br /> <input type="password" class="form-control-lg"
					id="userPassword" name="userPassword" required="required">

			</div>

			<div class="row">
				<div class="col">
					
						<a class="text-muted" href="userurl?action=question">Forgot
							Password?</a>
					

				</div>

			</div>


			<div class="row">
				<div class="col">
					<input class="btn btn-lg btn-success mt-3 me-5" type="submit"
						value="Login" />

				</div>
				<div class="col">
					<a class="btn btn-lg btn-primary mt-3" href="userurl?action=add">Register</a>
				</div>

			</div>


		</form>
	</div>
</body>
</html>

