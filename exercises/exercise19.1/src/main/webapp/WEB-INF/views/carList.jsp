<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cars currently in the shop</title>
</head>
<body>
	<h1>Cars currently in the shop</h1>
	<table>
	<c:forEach var="car" items="${cars}">
	<tr>
		<td>${car.make}</td>
		<td>${car.model}</td>
		<td>${car.year}</td>
		<td>${car.color}</td>
		<td><a href="cars/${car.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCar.html"> Add a Car</a>
</body>
</html>