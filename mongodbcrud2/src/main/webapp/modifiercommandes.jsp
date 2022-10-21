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
<h1>Modifier les informations d'une commande </h1>

<form action="modifierecommform" method="post">

<%
command c = (command)request.getAttribute("command");

%>
<form action="modifierecommform" method="post">
<div class="form-group row">
    <div class="col-sm-6">
      <input type="hidden" name="id" class="form-control" readonly  value="<%=c.getId() %>">
    </div>
    </div>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de produit</label>
    <div class="col-sm-6">
      <input type="text" name="nomp" class="form-control" value="<%=c.getNom_p() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de client</label>
    <div class="col-sm-6">
      <input type="text" name="nomc" class="form-control" value="<%=c.getNom_c() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="note" class="col-sm-2 col-form-label">Quantité</label>
    <div class="col-sm-6">
      <input type="text" name="qtt" class="form-control" value="<%=c.getQtt() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="note" class="col-sm-2 col-form-label">Date</label>
    <div class="col-sm-6">
      <input type="date" name="date" class="form-control" value="<%=c.getDate() %>">
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Ajouter</button>
</form>

</body>
</html>