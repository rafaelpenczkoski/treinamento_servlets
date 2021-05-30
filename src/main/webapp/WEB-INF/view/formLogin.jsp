<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/app/login" var="linkLogin" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${linkLogin}" method="post">
		<table>
			<tr>
				<td><label for="login">Login:</label></td>
				<td><input type="text" name="login" id="login" /></td>
			</tr>
			<tr>
				<td><label for="senha">Senha:</label></td>
				<td><input type="password" name="senha" id="senha" /></td>
			</tr>
		</table>
		<input type="submit" value="Enviar" />
	</form>
</body>
</html>