<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pojo.Book"%>
<%
Book book = (Book) request.getAttribute("book");
%>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
	<p>
		Are you sure you want to delete
		<%=book.getBookName()%>
		?
	</p>
	<form action="bookurl" method="post">
		<input type="hidden" name="action" value="delete" /> 
		<input type="hidden" name="bookId" value="<%=book.getBookId()%>"/>
		<input
			type="submit" class="btn btn-outline-danger" value="Delete" /> <a
			class="btn btn-outline-primary" href="bookurl?action=list">Cancel</a>
	</form>

</div>
<jsp:include page="footer.jsp"></jsp:include>