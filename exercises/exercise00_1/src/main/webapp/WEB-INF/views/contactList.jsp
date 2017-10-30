<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Contacts</title>
</head>
<body>
	<h1>List of Contacts:</h1>
	<table>
	<c:forEach var="contact" items="${contacts}">
	<tr>
		<td><a href="contacts/${contact.id}">${contact.name}</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<form action="contacts" method="post">
	<h2>Add a contact:</h2>
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" /> <input type="submit"/></td>
		</tr>
	</table>
	
	</form></body>
</html>