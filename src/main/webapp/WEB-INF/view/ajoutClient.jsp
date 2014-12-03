<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="include/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajout client</title>

</head>
	<body>
		<div class="row">
			<h2 class="col-md-8">Ajout d'un client</h2>
		</div>
		
		<div class="row">
			<form:form role="form"
				action="${pageContext.request.contextPath}/listClients/add" method="POST"
				commandName="client">
				<div class="form-group">
					<form:label path="nom">Nom</form:label>
					<form:input path="nom" class="form-control" />
				</div>
		
				<div class="form-group">
					<form:label path="prenom">Prénom</form:label>
					<form:input path="prenom" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="dateNaissance">Date de naissance</form:label>
					<form:input path="dateNaissance" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="adresse">Adresse</form:label>
					<form:input path="adresse" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" class="form-control" />
				</div>
		
				<button type="submit" class="btn btn-default">Ajouter</button>
				<button type="reset" class="btn btn-default">Annuler</button>
		</form:form>
	</div>


	</body>
	
	<%@include file="include/footer.jsp"%>
	
</html>