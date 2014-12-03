<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="include/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supprimer un client</title>
</head>

<body>
		<div class="row">
			<h2 class="col-md-8">Supprimer un client</h2>
		</div>
		
		<div class="row">
			<form:form role="form"
				action="${pageContext.request.contextPath}/listClients/delete/${client.id}" method="POST"
				commandName="client">
				
		
				<button type="submit" class="btn btn-default">Confirmer la suppression?</button>
				<button type="reset" class="btn btn-default">Annuler</button>
		</form:form>
	</div>


	</body>
	
	<%@include file="include/footer.jsp"%>
	
</html>