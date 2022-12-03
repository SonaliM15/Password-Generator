<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pojo.Book" import="java.util.List" import="pojo.User"%>
<%
List<Book> blist = (List<Book>) session.getAttribute("blist");
User user = (User)session.getAttribute("user");

if(user != null && user.getUserRole().equals("Customer"))
{
%>
<jsp:include page="cust_header.jsp"></jsp:include>

<div class="container-fluid" style="height: 500px; overflow: auto;">
	<table class="table text-center mt-5 mb-5" id="book_tab">
		<thead>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Price</th>
			
		</thead>
		<tbody>
			<%
			for (Book book : blist) {
			%>
			<tr>
				<td><%=book.getBookId()%></td>
				<td><%=book.getBookName()%></td>
				<td><%=book.getBookPrice()%></td>
				
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</div>
<%}else { %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid" style="height: 500px; overflow: auto;">
	<table class="table text-center mt-5 mb-5" id="book_tab" >
		<thead>
			<th>Book Id</th>
			<th>Book Name</th>
			<th>Price</th>
			<th>Action</th>
		</thead>
		<tbody>
			<%
			for (Book book : blist) {
			%>
			<tr>
				<td><%=book.getBookId()%></td>
				<td><%=book.getBookName()%></td>
				<td><%=book.getBookPrice()%></td>
				<td><a class="btn btn-outline-warning"
					href="bookurl?action=update&bookId=<%=book.getBookId()%>">Update</a>
					<a class="btn btn-outline-danger"
					href="bookurl?action=delete&bookId=<%=book.getBookId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</div>

<%} %>
<jsp:include page="footer.jsp"></jsp:include>