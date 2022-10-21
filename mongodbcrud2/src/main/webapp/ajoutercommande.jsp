<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Collection"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Ajouter une commande</h1>
<%
Collection<String>  cs =  (Collection<String>)request.getAttribute("cs");
Collection<String>  ps =  (Collection<String>)request.getAttribute("ps");
%>
<form action="ajoutercomm" method="post">
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de produit</label>
    <div class="col-sm-6">
<select class="form-control" name="produit" >
    <%
	for(String i : ps){
%>
	<option ><%= i %></option>
		
<%
	}
%>
    </select>    </div>
  </div>
  <div class="form-group row">
    <label for="note" class="col-sm-2 col-form-label">Nom de client</label>
    <div class="col-sm-6">
    <select class="form-control" name="client" >
    
    
    <%
	for(String e : cs){
%>
	<option ><%= e %></option>
		
<%
	}
%>
    </select>
    
    
    
    
    </div>
  </div>
  <div class="form-group row">
    <label for="note" class="col-sm-2 col-form-label">Quantité</label>
    <div class="col-sm-6">
      <input type="text" name="qtt" class="form-control"  placeholder="Quantité">
    </div>
  </div>
  <div class="form-group row">
    <label for="note" class="col-sm-2 col-form-label">Date</label>
    <div class="col-sm-6">
      <input type="date" name="date" class="form-control">
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Ajouter</button>
</form>

</body>
</html>