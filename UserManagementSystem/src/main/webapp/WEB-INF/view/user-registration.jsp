<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management System</title>
<link rel="stylesheet" href="css/style.css" /> 
</head>
<body>
	<div class="header">
		<h2>Welcome to User Management System</h2>
		<h3>Return to home page:</h3>
		 <a href="/">Home</a>
	</div>
	<hr>
	<div class="body">
		<div class="error">
			<c:choose>
			  <c:when test="${error==true}">
			   	<p>A user already exists with this username, try a different username.</p>
			  </c:when>
			</c:choose>
		</div>
		<form:form method="post" action="/user-registration" modelAttribute="user">			
			<table>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" required="required"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" required="required"/></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstname" required="required"/></td>
				</tr>			
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastname" required="required"/></td>
				</tr>	
				<tr>
					<td>email:</td>
					<td><form:input path="email" required="required"/></td>
				</tr>				
				<tr>
					<td colspan="2"><form:input type="submit" path="" value="Register"/></td>
				</tr>	
													
			</table>
		</form:form>
	</div>
	<hr>
	<div class="footer">
		<p>copyrights � 2019</p>
	</div>	
</body>
</html>