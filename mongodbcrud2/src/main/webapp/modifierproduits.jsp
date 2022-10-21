<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.produit"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Modifier les informations d'un produit </h1>

<form action="modifierproduit" method="post">
<%
produit e = (produit)request.getAttribute("produit");
%>
  <div class="form-group row">
    <div class="col-sm-6">
      <input type="hidden" name="id" class="form-control" readonly  value="<%=e.getId() %>">
    </div>
    </div>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de produit</label>
    <div class="col-sm-6">
      <input type="text" name="nom" class="form-control"  value="<%=e.getPnom() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="prix" class="col-sm-2 col-form-label">Prix de produit</label>
    <div class="col-sm-6">
      <input type="text" name="prix" class="form-control"  value="<%=e.getPrix() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="couleur" class="col-sm-2 col-form-label">Couleur de produit</label>
    <div class="col-sm-6">
      <input type="text" name="couleur" class="form-control"  value="<%=e.getCouleur() %>" >
    </div>
  </div>
   <div class="form-group row">
    <label for="caract" class="col-sm-2 col-form-label">les caracteristique de produit</label>
    <div class="col-sm-6">
      <input type="text" name="caract" class="form-control" value="<%=e.getCaract() %>" >
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Modifier</button>
</form>

</body>
</html>