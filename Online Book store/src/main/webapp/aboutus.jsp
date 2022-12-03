<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="pojo.User"%>

<%
User user = (User) session.getAttribute("user");
if (user != null && user.getUserRole().equals("Customer")) {
%>
<jsp:include page="cust_header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row mt-2 mb-2">
		<div class="col ms-2" >
			<p style="text-indent: 80px; font-size: 20px">Lorem, ipsum dolor sit amet consectetur
					adipisicing elit. Possimus dolor eum id sed consequatur, assumenda
					iste vitae saepe accusamus temporibus optio eius tempora enim quos
					ipsum modi officiis voluptate iusto corporis laboriosam nostrum sit
					totam. Velit amet quis, repudiandae obcaecati blanditiis recusandae
					maiores et quas, iure officiis minima cumque vitae est aliquid
					commodi praesentium dolorum officia laborum sit natus! Est amet
					vitae qui doloribus id natus laudantium earum reprehenderit, sint
					expedita odit neque alias libero quibusdam molestiae accusamus
					quia. Eos!</p>

		</div>
		<div class="col">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3769.7231362463385!2d72.8478964143774!3d19.119798155564055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c984163a9269%3A0x6d6da73fe2055ccf!2sItvedant%20Education%20Pvt.%20Ltd%20-%20Andheri!5e0!3m2!1sen!2sin!4v1654583213867!5m2!1sen!2sin"
				width="600" height="450" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>

</div>

<%
} else if (user != null && user.getUserRole().equals("Admin")) {
%>


<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
	<div class="row mt-2 mb-2">
		<div class="col ms-2" >
			<p style="text-indent: 80px; font-size: 20px">Lorem, ipsum dolor sit amet consectetur
					adipisicing elit. Possimus dolor eum id sed consequatur, assumenda
					iste vitae saepe accusamus temporibus optio eius tempora enim quos
					ipsum modi officiis voluptate iusto corporis laboriosam nostrum sit
					totam. Velit amet quis, repudiandae obcaecati blanditiis recusandae
					maiores et quas, iure officiis minima cumque vitae est aliquid
					commodi praesentium dolorum officia laborum sit natus! Est amet
					vitae qui doloribus id natus laudantium earum reprehenderit, sint
					expedita odit neque alias libero quibusdam molestiae accusamus
					quia. Eos!</p>

		</div>
		<div class="col">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3769.7231362463385!2d72.8478964143774!3d19.119798155564055!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3be7c984163a9269%3A0x6d6da73fe2055ccf!2sItvedant%20Education%20Pvt.%20Ltd%20-%20Andheri!5e0!3m2!1sen!2sin!4v1654583213867!5m2!1sen!2sin"
				width="600" height="450" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>
	</div>

</div>

<%
}
%>

<jsp:include page="footer.jsp"></jsp:include>