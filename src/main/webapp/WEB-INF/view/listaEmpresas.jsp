<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas</title>
</head>
<body>
	<c:if test="${not empty nomeEmpresa}">
		<p>Empresa ${ nomeEmpresa } criada com sucesso!</p>
	</c:if>

	<h2>Lista de empresas</h2>
	
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Data de abertura</th>
				<th>Operações</th>
			</tr>
		</thead>
		<tbody>		
		<c:forEach items="${listaEmpresas}" var="empresa">			
			<fmt:parseDate  value="${empresa.dataAbertura}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
			<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="dataFormatada" />
			<tr>
				<td width="20%" style="text-align: center;">${ empresa.nome }</td>
				<td width="50%" style="text-align: center;">${ dataFormatada }</td>
				<td>
					
					<c:url value="/app/mostraEmpresa" var="linkMostraEmpresa"/>
					<c:url value="/app/removeEmpresa" var="linkRemoveEmpresa"/>
					<a href="${linkMostraEmpresa}?id=${empresa.id}">Editar</a>
					<a href="${linkRemoveEmpresa}?id=${empresa.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<p>Usuário logado: ${usuarioLogado.login}</p>
	<c:import url="logout-partial.jsp" />
</body>
</html>