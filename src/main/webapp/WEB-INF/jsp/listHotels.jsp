<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<br/>
		<form method="POST" action="listHotels">
			<button type="submit">Log out</button>
		</form>
		<br/>
		<table border="1" style="width:300px">
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${hotelList}" var="hotel" varStatus="i">
			<c:url value="viewHotel" var="viewUrl">
				<c:param name="code" value="${hotel.code}" />
			</c:url>
			<c:url value="editHotel" var="editUrl">
				<c:param name="code" value="${hotel.code}" />
			</c:url>
			<tr>
				<td>
					<c:out value="${hotel.code}"/>
				</td>
				<td>
					<c:out value="${hotel.description}"/>
				</td>
				<td>
					<a href="${viewUrl}">
						<c:out value="${hotel.name}"/>
					</a>
				</td>
				<td>
					<a href="${editUrl}">
						<button type="submit">Edit</button>
					</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>