<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
	<h1>Details for Hotel:</h1>
		<c:url value="editHotel" var="saveUrl">
			<c:param name="code" value="${hotel.code}" />
		</c:url>
		<form method="POST" action="${saveUrl}">
			<table border="1" style="width:300px">
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
				<tr>
					<td>
						<c:out value="${hotel.code}"/><!--TODO: handle without querystring?-->
					</td>
					<td>
						<input  name ="description" value="${hotel.description}">
					</td>
					<td>
						<input  name ="name" value="${hotel.name}">
					</td>
					<td>
						<button type="submit">Save</button>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>