<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.client"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Modifier les informations d'un clients </h1>

<form action="modifierclient" method="post">
<%
client e = (client)request.getAttribute("client");
%>
  <div class="form-group row">
    <div class="col-sm-6">
      <input type="hidden" name="id" class="form-control" readonly  value="<%=e.getId() %>">
    </div>
    </div>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom</label>
    <div class="col-sm-6">
      <input type="text" name="nom" class="form-control"  value="<%=e.getNom() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="prenom" class="col-sm-2 col-form-label">Prenom</label>
    <div class="col-sm-6">
      <input type="text" name="prenom" class="form-control"  value="<%=e.getPrenom() %>" >
    </div>
  </div>
  <div class="form-group row">
    <label for="adress" class="col-sm-2 col-form-label">Adresse</label>
    <div class="col-sm-6">
      <input type="text" name="adress" class="form-control"  value="<%=e.getAdress() %>" >
    </div>
  </div>
   <div class="form-group row">
    <label for="phone" class="col-sm-2 col-form-label">Numero de telephone</label>
    <div class="col-sm-6">
      <input type="text" name="phone" class="form-control" value="<%=e.getPhone() %>" >
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Modifier</button>
</form>

</body>
</html>