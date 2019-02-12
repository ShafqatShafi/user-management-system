<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management System</title>
<link rel="stylesheet" href="/css/style.css" /> 
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
			<a href="/admin-dashboard">Dashboard</a>  
			<a href="/users">All Users</a>
			<button class="back-button" onclick="goBack()">back</button>
		</div>
	</div>
	<hr>
	<div class="body">	
		<c:choose>
		  <c:when test="${empty users}">
		   	<h3>You have no pending Approvals.</h3>
		  </c:when>
		  <c:otherwise>
			<h3>You have some pending approvals.</h3>
			<table class="tbl-users" border="1px">
				<tr>
					<th>S.NO</th>
					<th>Username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>email</th>
					<th>Action</th>
				</tr>
				<c:set var="count" scope="session" value="${0}" />
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${count=count+1}</td>
						<td>${user.username}</td>
						<td>${user.firstname}</td>
						<td>${user.lastname}</td>
						<td>${user.email}</td>
						<td><a href="/approve/${user.userId}">Approve</a> <a href="/reject/${user.userId}">Reject</a></td>
					</tr>				
				</c:forEach>			
			</table>
		  </c:otherwise>
		</c:choose>
	</div>
	<hr>
	<div class="footer">
		<p>copyrights © 2019</p>
	</div>
</body>
</html>