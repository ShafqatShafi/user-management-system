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
	</div>
	<hr>
	<div class="body">
		<table>
			<tr>
				<td>New User</td>
				<td><a href="/user-registration">Register here</a></td>
			</tr>
			<tr>
				<td colspan="2">Already a member, login</td>
			</tr>			
			<tr>
				<td><a href="/user-login">User Login</a></td>
				<td><a href="/admin-login">Admin Login</a></td>
			</tr>
		</table>
	</div>
	<hr>
	<div class="footer">
		<p>copyrights © 2019</p>
	</div>	
</body>
</html>