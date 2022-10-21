<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Ajouter un produit</h1>

<form action="ajtprd" method="get">
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de produit</label>
    <div class="col-sm-6">
      <input type="text" name="nom" class="form-control" placeholder="Nom">
    </div>
  </div>
  <div class="form-group row">
    <label for="prix" class="col-sm-2 col-form-label">Prix de produit</label>
    <div class="col-sm-6">
      <input type="text" name="prix" class="form-control" placeholder="Prix">
    </div>
  </div>
  <div class="form-group row">
    <label for="couleur" class="col-sm-2 col-form-label">Couleur de produit</label>
    <div class="col-sm-6">
      <input type="text" name="couleur" class="form-control"  placeholder="Couleur">
    </div>
  </div>
  <div class="form-group row">
    <label for="caract" class="col-sm-2 col-form-label">Caractéristique de produit</label>
    <div class="col-sm-6">
      <input type="text" name="caract" class="form-control"  placeholder="Caractéristique">
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Ajouter</button>
</form>

</body>
</html>