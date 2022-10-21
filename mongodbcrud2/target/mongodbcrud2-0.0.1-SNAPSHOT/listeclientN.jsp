<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.client"%>
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
Collection<client>  cs =  (Collection<client>)request.getAttribute("clients");
%>

<table class="table table-striped">
	<tr>
		<th>Nom </th>
		<th>Prenom</th>
		<th>Adresse</th>
		<th>Numero de telephone</th>
	</tr>
<%
	for(client e : cs){
%>
	<tr>
		<td><%=e.getNom() %></td>
		<td><%=e.getPrenom()%></td>
		<td><%=e.getAdress() %></td>
		<td><%=e.getPhone() %></td>
		<td>
			<a href="modifierclient?id=<%=e.getId() %>" class="btn btn-success">Modifier</a>
			<a href="supprimerclient?id=<%=e.getId() %>" class="btn btn-danger">Supprimer</a>
		</td>
	</tr>
<%
	}
%>
</table>


</body>
</html>
	