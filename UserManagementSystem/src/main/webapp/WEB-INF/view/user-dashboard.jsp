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
</head>
<body>
	<div class="header">
		<h2>Welcome to User Management System</h2>
		<h3>Return to home page:</h3>
		 <a href="/">Home</a>
	</div>
	<hr>
	<div class="body">
		<table>
			<tr>
				<td>Username:</td>
				<td>${user.username}</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td>${user.password}</td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td>${user.firstname}</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${user.lastname}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="/user-update/${user.userId}">Update Profile</a>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="footer">
		<p>copyrights © 2019</p>
	</div>
</body>
</html>