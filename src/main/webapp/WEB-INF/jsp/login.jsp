<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<h1>Hotel app!</h1>
		<c:if test="${param.error == 'true'}"> 
			<span>
				<font color="red">Error try again</font>
			</span>
			<br/>
		</c:if>
		<span>Sign in to access</span><br/>
		<form method="POST" action="login">
			<strong>
				<label for="username">Username:</label>
			</strong>
			<input type="username" value="" name="username">
			<br/>
			<strong>
				<label for="password">Password:</label>
			</strong>
			<input type="password" value="" name="password">
			<br/>
			<input type="submit" name="login" value="Log In">
		</form>
	</body>
</html>