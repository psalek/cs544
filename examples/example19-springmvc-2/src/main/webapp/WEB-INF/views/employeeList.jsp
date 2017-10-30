<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Employee List</title>
	
	</head>
	<body>
		<div id="global">
			<fieldset>
				<legend>Employee List</legend>
				<table style="width: 100%">
					<tr>
						<td><b>Index</b></td>
						<td><b>SSN</b></td>
						<td><b>Gender</b></td>
						<td><b>Name</b></td>
						<td><b>Email</b></td>
						<td><b>Salary</b></td>
					</tr>
					<c:forEach items="${employees}" var="employee" varStatus="count">
						<tr>
							<td>${count.index + 1}</td>
							<td>${employee.ssn}</td>
							<td>${employee.gender}</td>
							<td>${employee.name}</td>
							<td>${employee.emailAddress}</td>
							<td>${employee.salary}</td>
						</tr>
					</c:forEach>
				</table>
				<a href="./">Home</a>
			</fieldset>
		</div>
	</body>
</html>