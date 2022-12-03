<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.User"%>
<%
String action = (String) request.getAttribute("action");
User user = (User) request.getAttribute("user");
User session_user = (User) session.getAttribute("user");
%>

<div class="container-fluid" style="height: 500px; overflow: auto;"
	>
	<%
	if (action != null && action.equals("update")) {
	%>
	<h1 class="text-center m-3">Update User details</h1>
	<%
	} else {
	%>
	<h1 class="text-center m-3">Registration Form</h1>
	<%
	}
	%>
	<form action="userurl" method="post" class="m-3 p-4">
		<input type="hidden" value="<%=action%>" name="action">
		<%
		if (action != null && action.equals("update")) {
		%>
		<div class="mb-3">
			<label for="userId" class="form-label"><strong>User
					Id</strong></label> <input type="text" class="form-control" id="userId" readonly="readonly"
				name="userId" value="<%=user.getUserId()%>">
		</div>
		<%
		}
		%>
		<div class="mb-3">
			<label for="firstName" class="form-label"><strong>First
					Name</strong></label> <input type="text" class="form-control" id="firstName"
				name="firstName" value="<%=user.getFirstName()%>"
				required="required">
		</div>
		<div class="mb-3">
			<label for="lastName" class="form-label"><strong>Last
					Name</strong></label> <input type="text" class="form-control" id="lastName"
				name="lastName" value="<%=user.getLastName()%>" required="required">
		</div>
		<div class="mb-3">
			<label for="userEmail" class="form-label"><strong>Email
					address</strong></label> <input type="email" class="form-control" id="userEmail"
				name="userEmail" aria-describedby="emailHelp"
				value="<%=user.getUserEmail()%>" required="required">
			<div id="emailHelp" class="form-text">We'll never share your
				email with anyone else.</div>
		</div>
		<div class="mb-3">
			<label for="userPassword" class="form-label"><strong>Password</strong></label>
			<input type="password" class="form-control" id="userPassword"
				name="userPassword" value="<%=user.getUserPassword()%>"
				required="required">
		</div>
		<div class="mb-3">
			<label for="userMobile" class="form-label"><strong>Mobile
					Number</strong></label> <input type="text" class="form-control" id="userMobile"
				name="userMobile" value="<%=user.getUserMobile()%>"
				required="required">
		</div>
		<%
		if (action != null && action.equals("add") && session_user == null) {
		%>
		<div class="mb-3">
			<label for="userRole" class="form-label"><strong>User
					Role</strong></label> <select  id="userRole" name="userRole" class="form-select"
				aria-label="Default select example" >
				<option selected >Customer</option>
			</select>
		</div>
		<div class="mb-3">
			<label for="userQuestion" class="form-label"><strong>Question</strong></label>
			<select id="userQuestion" name="userQuestion" class="form-select"
				aria-label="Default select example">
				<option selected>Select question</option>
				<option value="Where was you born?">Where was you born?</option>
				<option value="What is your mother's name?">What is your
					mother's name?</option>

			</select>
		</div>

		<%
		} else if (action != null && action.equals("update")) {
		%>
		<div class="mb-3">
			<label for="userRole" class="form-label"><strong>User
					Role</strong></label> <select id="userRole" name="userRole" class="form-select"
				aria-label="Default select example">
				<option value="Admin" <%if (user.getUserRole().equals("Admin")) {%>
					selected <%}%>>Admin</option>
				<option value="Customer"
					<%if (user.getUserRole().equals("Customer")) {%> selected <%}%>>Customer</option>

			</select>
		</div>
		<div class="mb-3">
			<label for="userQuestion" class="form-label"><strong>Question</strong></label>
			<select id="userQuestion" name="userQuestion" class="form-select"
				aria-label="Default select example">
				<option value="Where was you born?"
					<%if (user.getUserQuestion().equals("Where was you born?")) {%>
					selected <%}%>>Where was you born?</option>
				<option value="What is your mother's name?"
					<%if (user.getUserQuestion().equals("What is your mother's name?")) {%>
					selected <%}%>>What is your mother's name?</option>
			</select>
			<div id="question" class="form-text">Incase of password
				recovery ,you need to answer one of these question.</div>
		</div>

		<%
		} else {
		%>
		<div class="mb-3">
			<label for="userRole" class="form-label"><strong>User
					Role</strong></label> <select id="userRole" name="userRole" class="form-select"
				aria-label="Default select example">
				<option selected>Select user role</option>
				<option value="Admin">Admin</option>
				<option value="Customer">Customer</option>

			</select>
		</div>
		<div class="mb-3">
			<label for="userQuestion" class="form-label"><strong>Question</strong></label>
			<select id="userQuestion" name="userQuestion" class="form-select"
				aria-label="Default select example">
				<option selected>Select question</option>
				<option value="Where was you born?">Where was you born?</option>
				<option value="What is your mother's name?">What is your
					mother's name?</option>

			</select>
		</div>

		<%
		}
		%>
		<div class="mb-3">
			<label for="userAnswer" class="form-label"><strong>Answer</strong></label>
			<input type="text" class="form-control" id="userAnswer"
				name="userAnswer" value="<%=user.getUserAnswer()%>"
				required="required">
		</div>
		<div class="mb-3">
			<label for="address" class="form-label"><strong>Address</strong></label>
			<input type="text" class="form-control" id="address" name="address"
				value="<%=user.getUserAddress()%>" required="required">
		</div>
		
		<input class="btn btn-success" type="submit" value="Submit" />
	</form>

</div>