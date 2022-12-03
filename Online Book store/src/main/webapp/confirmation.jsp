<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pojo.User"%>
<%
User user = (User) request.getAttribute("user");
%>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<p>
		Are you sure you want to delete
		<%=user.getFirstName()%>?
	</p>
	<form action="userurl" method="post">
		<input type="hidden" name="action" value="delete" />
		<input type="hidden" name="userId" value="<%=user.getUserId()%>"/>
		 <input
			type="submit" class="btn btn-outline-danger" value="Delete" /> <a
			class="btn btn-outline-primary" href="userurl?action=list">Cancel</a>
	</form>

</div>
<jsp:include page="footer.jsp"></jsp:include>