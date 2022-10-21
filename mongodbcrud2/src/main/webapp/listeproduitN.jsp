<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.produit"%>
<%@page import="java.util.Collection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<br /> <br />
<%
Collection<produit>  cs =  (Collection<produit>)request.getAttribute("produits");
%>

<table class="table table-striped">
	<tr>
		<th>Nom de produit</th>
		<th>Prix de produit</th>
		<th>Couleur de produit</th>
	    <th>Caracteristique de produit</th>
	</tr>
<%
	for(produit e : cs){
%>
	<tr>

		<td><%=e.getPnom() %></td>
		<td><%=e.getPrix() %></td>
		<td><%=e.getCouleur() %></td>
		<td><%=e.getCaract() %></td>
		<td>
			<a href="modifieretudiantform?id=<%=e.getId() %>" class="btn btn-success">Modifier</a>
			<a href="supprd?id=<%=e.getId() %>" class="btn btn-danger">Supprimer</a>
		</td>
	</tr>
<%
	}
%>
</table>


</body>
</html>
	