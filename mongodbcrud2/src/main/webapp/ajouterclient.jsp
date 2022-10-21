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
<h1>Ajouter un client</h1>

<form action="ajouterclient" method="get">
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom de client</label>
    <div class="col-sm-6">
      <input type="text" name="nom" class="form-control" placeholder="Nom">
    </div>
  </div>
  <div class="form-group row">
    <label for="prenom" class="col-sm-2 col-form-label">Prenom de client</label>
    <div class="col-sm-6">
      <input type="text" name="prenom" class="form-control" placeholder="Prenom">
    </div>
  </div>
  <div class="form-group row">
    <label for="adresse" class="col-sm-2 col-form-label">Adresse</label>
    <div class="col-sm-6">
      <input type="text" name="adresse" class="form-control"  placeholder="adresse">
    </div>
  </div>
  <div class="form-group row">
    <label for="num" class="col-sm-2 col-form-label">Numero de telephone</label>
    <div class="col-sm-6">
      <input type="text" name="num" class="form-control"  placeholder="Numéro de téléphone">
    </div>
  </div>
  <button type="submit" class="btn btn-danger mb-2">Ajouter</button>
</form>

</body>
</html>