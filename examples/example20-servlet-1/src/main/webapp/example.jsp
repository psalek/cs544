<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Hello Example</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<p>
		Current date &amp; time on server:
		<%!Date now = new Date();%>
		<%
			if (now.after(new Date(0))) {
		%>
		<%=now%>
		<%
			} // end if
		%>
	</p>
	<br/>
	<p><a href="index.html">Home</a></p>
</body>
</html>