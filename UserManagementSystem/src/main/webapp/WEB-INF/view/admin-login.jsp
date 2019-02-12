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
<script type="text/javascript">
function goBack() {
    window.history.back()
}
</script>
</head>
<body>
	<div class="header">
		<h2>Welcome to User Management System</h2>
		<div class="nav-bar">
			<a href="/">Home</a> 
			<button class="back-button" onclick="goBack()">back</button>
		</div>
	</div>
	<hr>
	<div class="body">
		<div>
			<c:choose>
			  <c:when test="${error==true}">
			   	<p>Either Username or Password was invalid.</p>
			  </c:when>
			</c:choose>
		</div>
		
		<form:form method="post" action="/admin-login" modelAttribute="admin">			
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><form:input type="submit" path="" value="Login"/></td>
			</tr>			
		</table>
		</form:form>
	</div>
	<hr>
	<div class="footer">
		<p>copyrights © 2019</p>
	</div>	
</body>
</html>