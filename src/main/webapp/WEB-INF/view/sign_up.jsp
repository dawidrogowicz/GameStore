<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
Registration
<br>
	<div class="registration">
		<form action="/register" method="POST">
		username: 
			<input type="text" name="username">
		email:
			<input type="text" name="email">
		pass:
			<input type="password" name="password">
			<input type="password" name="rep_password">
			
			<input type="submit" value="Register">
		</form>
		
		<div class="error">
			<br><p>wrong data</p>
		</div>
		<a href="/">Back to shop</a>
	</div>
</body>
</html>