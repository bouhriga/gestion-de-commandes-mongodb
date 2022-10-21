<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.command"%>
<%@page import="java.util.Collection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1>Liste des commandes</h1>
<a href="ajoutercomm" class="btn btn-primary">Creer</a>
<hr>
<h1> chercher avec la date de commande?</h1>
<form action="cherchercommand" method="get">
<input  type="date" name="chercherdate" class="form-control">
<button type="submit" class="btn btn-danger mb-2">chercher</button>

</form>
<br /> <br />
<%
Collection<command>  cs =  (Collection<command>)request.getAttribute("commandes");
%>

<table class="table table-striped">
	<tr>
		<th>Nom de produit</th>
		<th>Client</th>
	    <th>adresse de client</th>
	    <th>numero de telephone</th>
	    <th>caracteristique</th>
		<th>Prix</th>
		<th>couleur</th>
		<th>quantité</th>
	    <th>Date </th>
	</tr>
<%
	for(command e : cs){
%>
	<tr>

		<td><%=e.getNom_p() %></td>
		<td><%=e.getNom_c() %>  &nbsp; <%=e.getPrenom_c() %></td>
		<td><%=e.getAdress() %></td>
		<td><%=e.getPhone() %></td>
		<td><%=e.getCaract() %></td>
		<td><%=e.getPrix() %></td>
		<td><%=e.getCouleur() %></td>
		<td><%=e.getQtt() %></td>
		<td><%=e.getDate() %></td>
		<td>
			<a href="modifierecommform?id=<%=e.getId() %>" class="btn btn-success">Modifier</a>
			<a href="supprimercomm?id=<%=e.getId() %>" class="btn btn-danger">Supprimer</a>
		</td>
	</tr>
<%
	}
%>
</table>




</body>
</html>
	