<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.User"%>

<%
String action = (String) request.getAttribute("action");
User session_user = (User) session.getAttribute("user");
User user = (User) request.getAttribute("user");

if (session_user != null && session_user.getUserRole().equals("Admin")) {
%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="reg_body.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>
<%
} else if (session_user == null ) {
%>

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
	<jsp:include page="reg_body.jsp"></jsp:include>
</body>
</html>

<%
}
%>