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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
	
    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link
      href="https://fonts.googleapis.com/css?family=Poppins|Raleway:400,600|Righteous&display=swap"
      rel="stylesheet"
    />
</head>
<body>
<section >
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	    	<a class="navbar-brand" href="index.jsp">Bouhriga <span>Magazine</span></a>
	    	<form action="chercherclient" class="searchform order-sm-start order-lg-last">
          <div class="form-group d-flex">
            <input type="text" class="form-control pl-3"  name="cherchernom" placeholder="Chercher avec nom">
            <button type="submit" placeholder="" class="form-control search"><span class="fa fa-search"></span></button>
          </div>
        </form>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="fa fa-bars"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav m-auto">
	        	<li class="nav-item dropdown">
            </li>
	        	<li class="nav-item"><a href="ajouterclient.jsp" class="nav-link">Creer</a></li>
	        	<li class="nav-item"><a href="PDFExportclient" class="nav-link">Imprimer</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

	</section>
<center><h1>Liste des clients</h1></center>


<br /> <br />
<%
Collection<client>  cs =  (Collection<client>)request.getAttribute("clients");
%>

<table class="table table-striped">
	<tr>
		<th>Nom </th>
		<th>Prenom </th>
		<th>adresse</th>
		<th>Numéro de telephone</th>
		<th></th>
	</tr>
<%
	for(client e : cs){
%>
	<tr>
		<td><%=e.getNom() %></td>
		<td><%=e.getPrenom() %></td>
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
	