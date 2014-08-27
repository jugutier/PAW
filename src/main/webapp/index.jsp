<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Page Redirection</title>
</head>
<body>
<center>
<h1>Page Redirection</h1>
</center>
<%
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", "/login"); 
%>
</body>
</html>
