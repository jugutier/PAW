<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<a href="listHotels">back</a>
		<h1>Details for Hotel:</h1>
		<table border="1" style="width:300px">
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<tr>
				<td>
					<c:out value="${hotel.code}"/>
				</td>
				<td>
					<c:out value="${hotel.description}"/>
				</td>
				<td>
					<c:out value="${hotel.name}"/>
				</td>
			</tr>
		</table>
		<c:choose>
		    <c:when test="${empty comments}">
		        <h2>No comments yet, be the first to comment!</h2>
		    </c:when>
		    <c:otherwise>
		        <h2>Other users commented:</h2><br/>
		        <c:forEach items="${comments}" var="comment">
					<span>
						<strong>name: </strong><c:out value="${comment.userInfo.name}"/>
					</span>
					<br/>
					<span>
						<strong>email: </strong><c:out value="${comment.userInfo.email}"/>
					</span>
					<br/>
		 			<tr>
		 				<div>
		 					<p>
		 						<strong>comment: </strong>
		 						<c:out value="${comment.text}"/>
		 					</p>
		 				</div>
		 			</tr>
				<hr width="300" align="left">
				</c:forEach>
		    </c:otherwise>
		</c:choose>
		<h3>Submit a comment:</h3>
		<c:url value="addComment" var="commentUrl">
				<c:param name="code" value="${hotel.code}" />
			</c:url>
		<form method="POST" action="${commentUrl}">
			<strong>name:</strong> <label><c:out value="${userinfo.name}"/></label><br/>
			<strong>email:</strong> <label><c:out value="${userinfo.email}"/></label><br/>
			<strong>comment:</strong> <input style="width=300px;height=300px;" name ="text" value="write a comment here"/><br/>
			<button type="submit">Submit</button>
		</form>
	</body>
</html>