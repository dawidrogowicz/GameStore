<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script src="/resources/js/jquery-3.2.0.js"></script>
	<script type="text/javascript">

	</script>
<title>Game Store</title>
</head>
<body>
	<div class="container">
		<div class="fxdPanel">
			<h1>Game Store</h1>
			<c:choose>
			<c:when test="${loggedIn}">
				<div class="userDetails">
					<h5><c:out value="${username}"/></h5>
					</div>
			</c:when>
			<c:otherwise>
			<div class="loggingPanel">
				<form action="/sign_in" method="POST">
					<input type="text" name="username">
					<input type="password" name="password">
					<input type="submit" value="Sign in">
				</form>
				<a href="/sign_up">Register</a>
			</div>
			</c:otherwise>
			</c:choose>

		</div>

		<div class="mainFrame">
			<div class="header">
				<div class="picture"></div>
				<div class="categories">
					<ul>
						<li>PC</li>
						<li>PS4</li>
						<li>XBOX</li>
					</ul>
				</div>
			</div>

			<div class="content">
				<input type="text" id="searchBox">

				<table>
					<tr>
						<td id="itemName">Battlefield 1</td>
						<td id="itemPrice">$35</td>
						<td id="itemBuyNow">Buy Now</td>
					</tr>
					<tr>
						<td id="itemName">Witcher 3</td>
						<td id="itemPrice">$25</td>
						<td id="itemBuyNow">Buy Now</td>
					</tr>
					<tr>
						<td id="itemName">GTA V</td>
						<td id="itemPrice">$30</td>
						<td id="itemBuyNow">Buy Now</td>
					</tr>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
