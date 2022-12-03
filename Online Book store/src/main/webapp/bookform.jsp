<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="pojo.Book"%>

<%
String action = (String) request.getAttribute("action");
Book book = (Book) request.getAttribute("book");
%>

<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
	<h1>Book Form</h1>
	<form action="bookurl" method="post" 
		name="bookForm">
		<input type="hidden" name="action" value="<%=action%>" />

		<%
		if (action.equals("update")) {
		%>

		<div class="mb-3">
			<label for="bookId" class="form-label">Book Id</label> <input
				type="number" class="form-control" id="bookId" name="bookId"
				readonly value="<%=book.getBookId()%>">
		</div>

		<%
		}
		%>
		<div class="mb-3">
			<label for="bookName" class="form-label">Book Name</label> <input
				type="text" class="form-control" id="bookName" name="bookName" 
				placeholder="Enter book name" value="<%=book.getBookName()%>" required="required">
		</div>

		<div class="mb-3">
			<label for="bookPrice" class="form-label">Book Price</label> <input
				type="text" class="form-control" id="bookPrice" name="bookPrice"
				placeholder="Enter book price" value="<%=book.getBookPrice()%>" required="required">
		</div>

		<input class="btn btn-success"  type="submit" value="Submit" />

	</form>


</div>



<jsp:include page="footer.jsp"></jsp:include>