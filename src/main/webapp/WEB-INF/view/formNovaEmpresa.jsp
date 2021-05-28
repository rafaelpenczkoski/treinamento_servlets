<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novaEmpresa" var="linkNovaEmpresa"/>
<c:url value="/editaEmpresa" var="linkEditaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de empresa</title>
</head>
<body>
	<form action="${empresa.id != null ? linkEditaEmpresa :linkNovaEmpresa}" method="post">
		<table>
			<tr>
				<td>
					<label for="nome">Nome:</label>
					
				</td>
				<td>
					<input type="text" name="nome" id="nome" value="${empresa.nome}"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="dataAbertura">Data de abertura:</label>
				</td>
				<td>
					<input type="date" name="dataAbertura" id="dataAbertura" value="${empresa.dataAbertura}"/>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${empresa.id}" name="id" />
		<input type="submit" value="Enviar"/>
	</form>
</body>
</html>