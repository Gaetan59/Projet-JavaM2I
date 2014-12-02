<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client</title>
</head>

	<body>
	<h2>Liste des clients</h2>
	<a href="${pageContext.request.contextPath}/listClients/add">Ajout d'un client</a>
	
	<table class="table table-striped table-hover">
		<c:forEach items = "${clients}" var = "client">
			<tr>
				<td>${client.id}</td>
				<td>${client.nom}</td>
				<td>${client.prenom}</td>
				<td>${client.naissance}</td>
				<td>${client.adresse}</td>
				<td>${client.email}</td>
				<td>
					<a href="${pageContext.request.contextPath}/commande/${client.id}">Commande</a>
					<a href="${pageContext.request.contextPath}/listClients/edit/${client.id}" >Modifier</a>
					<a href="${pageContext.request.contextPath}/listClients/delete/${client.id}">Supprimer</a>
				</td>
			</tr>
		
	
			
		</c:forEach>	
	</table>
	
	
	</body>
	
</html>