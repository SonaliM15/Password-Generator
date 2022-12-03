<%@page import="pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"%>
<%
List<User> ulist = (List<User>) session.getAttribute("ulist");
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid " style="height: 500px; overflow: auto;">

	<div class="table-responsive">
		<table class="table  text-center mt-5 mb-5" id="user_tab">
			<thead>
				<th>User Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Mobile</th>
				<th>User Role</th>
				<th>Address</th>
				<th>Action</th>
			</thead>
			<tbody>
				<%
				for (User user : ulist) {
				%>
				<tr>
					<td><%=user.getUserId()%></td>
					<td><%=user.getFirstName()%></td>
					<td><%=user.getLastName()%></td>
					<td><%=user.getUserEmail()%></td>
					<td><%=user.getUserMobile()%></td>
					<td><%=user.getUserRole()%></td>
					<td><%=user.getUserAddress()%></td>
					<td><a class="btn btn-outline-warning"
						href="userurl?action=update&userId=<%=user.getUserId()%>">Update</a>
						<a class="btn btn-outline-danger"
						href="userurl?action=delete&userId=<%=user.getUserId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>


</div>
<jsp:include page="footer.jsp"></jsp:include>