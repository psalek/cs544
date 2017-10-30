<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Contact</title>
</head>
<body>
	<table>
		<tr>
			<td>Name:</td>
			<td>
				<form action="../contacts/${contact.id}" method="post">
					<input type="text" name="name" value="${contact.name}" /> <input
						type="hidden" name="id" value="${contact.id}" />
				</form>
			</td>
		</tr>
		<tr>
			<td>Phone:</td>
			<td>
				<ul>
					<c:forEach var="phone" items="${contact.phones}">
						<li>${phone.phone}</li>
					</c:forEach>
				</ul>
				<form method="POST" action="../contacts/${contact.id}/addPhone">
					<input type="submit" value="Add number"/> <input type="text" name="phone" /> 
				</form>
			</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>
				<ul>
					<c:forEach var="email" items="${contact.emails}">
						<li>${email.email}</li>
					</c:forEach>
				</ul>
				<form method="POST" action="../contacts/${contact.id}/addEmail">
					<input type="submit" value="Add email"/> <input type="text" name="email" />
				</form>

			</td>
		</tr>
	</table>
	<input type="submit" value="update" />

	<form action="../contacts/delete/${contact.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>