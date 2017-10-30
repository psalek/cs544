<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>Welcome Page</h2>
		<a href="<c:url value="/user"/>">user page</a> | <a href="<c:url value="/admin"/>">admin page</a>
	</body>
</html>
