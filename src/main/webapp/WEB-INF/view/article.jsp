<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="include/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des musiques</title>

</head>
	<body>
		<div class="row">
			<h2 class="col-md-8">Liste des Musiques</h2>
		</div>
		
		<a href="${pageContext.request.contextPath}/listClients/add" class="btn btn-info btn-lg">Ajout Musique</a>
	
		<table class="table table-striped table-hover">
		<c:forEach items = "${articles}" var = "article">
			<tr>
				<td>${Article.id}</td>
				<td>${album.nom}</td>
				<td>${titre.musique}</td>
				<td>${album.year}</td>
				<td>${titre.year}</td>
				
				
				<td>
					<a href="${pageContext.request.contextPath}/commande/${client.id}" class="btn btn-primary btn-sm">Commande</a>
					<a href="${pageContext.request.contextPath}/listalbum/edit/${album.id}" class="btn btn-success btn-sm">Modifier</a>
					<a href="${pageContext.request.contextPath}/listetitre/edit/${titre.id}" class="btn btn-success btn-sm">Modifier</a>
					<a href="${pageContext.request.contextPath}/listetitre/delete/${titre.id}" class="btn btn-warning btn-sm delete">Supprimer</a>
					<a href="${pageContext.request.contextPath}/listealbum/delete/${titre.id}" class="btn btn-warning btn-sm delete">Supprimer</a>
				</td>
			</tr>
	
			
		</c:forEach>	
		</table>


	</body>
	
	<%@include file="include/footer.jsp"%>
	
</html>